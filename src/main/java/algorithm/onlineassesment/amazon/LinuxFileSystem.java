package algorithm.onlineassesment.amazon;
import java.util.*;

public class LinuxFileSystem {
    public enum FileType{
        xml, txt, json;
    }

    public class FileNode{
        String name;
        boolean isFile;
        String content;
        String type;
        int size;
        Map<String, HashSet<String>> fileByType;
        Map<String, HashSet<String>> fileBySize;
        HashSet<String> fileName;
        Map<String, FileNode> children;

        public FileNode(){
            isFile = false;
            content = null;
            type = null;
            size = 0 ;
            children = new HashMap<>();
            fileByType = new HashMap<>();
            fileBySize = new HashMap<>();
            fileName = new HashSet<>();
        }

        @Override
        public String toString() {
            return (isFile ? "File - ": "Dir - ")+"Name : "+name;
        }
    }

    private FileNode root;
    public LinuxFileSystem(){
        root = new FileNode();
    }

    public void addDirectory(String path) {
        FileNode curr = root;
        addDirectory(curr, path.split("/") ,  0);
    }


    public void addDirectory(FileNode curr, String[] paths, int index){
        if (index==paths.length){
            curr.isFile = false;
            return;
        }

        String name = paths[index];
        FileNode file = curr.children.get(name);
        if (file == null){
            curr.children.put(name, new FileNode());
            file = curr.children.get(name);
        }
        file.name = paths[index];

        addDirectory(file, paths,  index+1);
    }

    public void addFile(String path,  String content){
        FileNode curr = root;
        String type = path.substring(path.lastIndexOf('.')+1);
        addFile(curr, path.split("/"), type,content , 0);
    }

    public void addFile(FileNode curr, String[] paths , String fileType , String content, int index){
        if (index==paths.length){
            curr.isFile = true;
            curr.content = content;
            curr.type = fileType;
            curr.size = content.length();
            return;
        }

        String name = paths[index];
        if (name.equals("")){
            throw new IllegalArgumentException("Not a valid file path");
        }
        FileNode file = curr.children.get(name);
        if (file == null){
            curr.children.put(name, new FileNode());
            file = curr.children.get(name);
        }
        file.name = paths[index];
        file.fileByType.computeIfAbsent(fileType, k -> new HashSet<>());
        file.fileByType.get(fileType).add(paths[paths.length-1]);
        file.fileName.add(paths[paths.length-1]);

        addFile(file, paths, fileType, content, index+1);
    }

    public List<String> getDirList(String path){
        FileNode curr = root;
        List<String> result = new ArrayList<>();
        getDirList(root, path.split("/"), 0, result);
        return result;
    }

    private void getDirList(FileNode curr, String[] paths, int index, List<String> result){
        if (paths.length==index){
            Map<String, FileNode> children = curr.children;
            result.add(children.entrySet().toString());
            return;
        }

        FileNode node = curr.children.get(paths[index]);
        if (node == null){
            return ;
        }else {
            getDirList(node, paths, index+1, result);
        }
    }

    public interface Filter{
        public boolean apply(FileNode file);
    }

    public static class SizeFilter implements Filter{
        @Override
        public boolean apply(FileNode file){
            if (file.size>10){
                return true;
            }
            return false;
        }
    }

    public static class NotFilter implements Filter{
        Filter filter;
        public NotFilter(Filter filter){
            this.filter = filter;
        }
        @Override
        public boolean apply(FileNode file) {
           return  !filter.apply(file);
        }
    }

    public static class AndFilter implements Filter{
        List<Filter> filters;
        public AndFilter(List<Filter> filters){
            this.filters = filters;
        }
        @Override
        public boolean apply(FileNode file) {
            for (Filter filter : filters){
                if (!filter.apply(file)){
                  return false;
                }
            }
            return true;
        }
    }

    public static class OrFilter implements Filter{
        List<Filter> filters;
        public OrFilter(List<Filter> filters){
            this.filters = filters;
        }
        @Override
        public boolean apply(FileNode file) {
            for (Filter filter : filters){
                if (filter.apply(file)){
                    return true;
                }
            }
            return false;
        }
    }


    public static class XmlFilter implements Filter{
        @Override
        public boolean apply(FileNode file){
            if (file.type.equals("xml")){
                return true;
            }
            return false;
        }
    }

    public static class TxtFilter implements Filter{
        @Override
        public boolean apply(FileNode file){
            if (file.type.equals("txt")){
                return true;
            }
            return false;
        }
    }

    public List<String> getFileListWithFilter(String path, List<Filter> filters, String filterType){
        if (path == null){
            path = "root";
        }
        List<String> result = new ArrayList<>();
        Queue<FileNode> q = new LinkedList<>();
        FileNode curr = root;
        q.offer(curr.children.get("root"));

        while (!q.isEmpty()){
            FileNode top = q.poll();
            if (top.isFile){
                if (filterType.equals("AND")){
                    if (new AndFilter(filters).apply(top)) {
                        result.add(top.name);
                    }
                }else {
                    if (new OrFilter(filters).apply(top)) {
                        result.add(top.name);
                    }
                }
            }

            Map<String,FileNode> children = top.children;
            for (Map.Entry<String , FileNode> entry : children.entrySet()){

                    q.offer(entry.getValue());

            }
        }

        return result;
    }


    public static void main(String[] args){
        LinuxFileSystem linuxFileSystem = new LinuxFileSystem();
        linuxFileSystem.addDirectory("root/suresh/babu1/Dir1");
        linuxFileSystem.addFile("root/suresh/babu1/file.txt",  "sample Content");
        linuxFileSystem.addFile("root/suresh/babu2/file.xml",  "sample XML Content");
        linuxFileSystem.addFile("root/suresh/babu2/file.json",  "sample json Content");
        linuxFileSystem.addFile("root/suresh/babu2/file1.txt",  "sample ");
        linuxFileSystem.addFile("root/suresh/babu2/file2.txt",  "sample1 ");
        System.out.println("Dir List "+linuxFileSystem.getDirList("root/suresh/babu1"));
        System.out.println("Dir List "+linuxFileSystem.getDirList("root/suresh/babu2"));
        System.out.println("XML List "+linuxFileSystem.root.children.get("root").fileByType.get("xml"));
        System.out.println("json List "+linuxFileSystem.root.children.get("root").fileByType.get("json"));
        System.out.println("txt List "+linuxFileSystem.root.children.get("root").fileByType.get("txt"));
     //  System.out.println("Complete List "+linuxFileSystem.getFileListWithFilter(null,null));
        List<Filter> xmlFilter = new ArrayList<>();
        xmlFilter.add(new XmlFilter());
        System.out.println("XML filter List "+linuxFileSystem.getFileListWithFilter(null,xmlFilter, "AND"));
        List<Filter> txtFilter = new ArrayList<>();
        txtFilter.add(new TxtFilter());
        System.out.println("TXT filter List "+linuxFileSystem.getFileListWithFilter(null,txtFilter, "AND"));
        List<Filter> xmlAndtxt = new ArrayList<>();
        xmlAndtxt.addAll(Arrays.asList(new TxtFilter(), new XmlFilter()));
        System.out.println("TXT or XML filter List "+linuxFileSystem.getFileListWithFilter(null,xmlAndtxt, "OR"));
        List<Filter> sizeFilter = new ArrayList<>();
        sizeFilter.add(new SizeFilter());
        System.out.println("Size filter List "+linuxFileSystem.getFileListWithFilter(null,sizeFilter, "AND"));
        List<Filter> notSizeFilter = new ArrayList<>();
        notSizeFilter.add(new NotFilter(new SizeFilter()));
        System.out.println("Size filter List "+linuxFileSystem.getFileListWithFilter(null,notSizeFilter, "AND"));
        List<Filter> sizeAndTxt = new ArrayList<>(Arrays.asList(new SizeFilter(), new TxtFilter()));
        System.out.println("txt Size filter List "+linuxFileSystem.getFileListWithFilter(null,sizeAndTxt, "AND"));

    }

}
