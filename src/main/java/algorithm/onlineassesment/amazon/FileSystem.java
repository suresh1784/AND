package algorithm.onlineassesment.amazon;
import java.util.*;
public class FileSystem {
    public interface IEntry{
    public boolean isFile();
    public String getName();
    public int getSize();
    }

    private static Directory root;
    public FileSystem(){
        root = new Directory("root");
    }

    public Directory getRoot(){
        return root;
    }

    public static abstract class Entry implements IEntry{
        @Override
        public String toString() {
           return "Entry { "+ "name : "+ getName() + " }";
        }


    }

    public static class File extends Entry{
        private String name;
        private String content;
        private boolean isFile;
        private String title;
        private String extension;
        public File(){

        }

        public File(String name, String content){
            this.name = name;
            this.content = content;
            this.isFile = true;
            setTitleAndExtension(name);
        }

        public void setTitleAndExtension(String fileName){
            if (fileName == null){
                throw new IllegalArgumentException("File name cannot be null.");
            }
            if (fileName.contains(".")){
                String names = fileName.substring(0, fileName.lastIndexOf('.'));
                String extension = fileName.substring(fileName.lastIndexOf('.')+1);
                if (!isValidExtension(extension)){
                    throw new IllegalArgumentException("Not a valid content");
                }
            }else {
                throw new IllegalArgumentException("Not a valid file name");
            }

        }

        private boolean isValidExtension(String extension){
            if (extension.length() ==3){
                return true;
            }
            return false;
        }

        public String getTitle(){
            return title;
        }

        public String getExtension(){
            return title;
        }

        @Override
        public boolean isFile() {
            return isFile;
        }

        @Override
        public String getName() {
            return name;
        }

        public String getContent(){
            return content;
        }

        @Override
        public int getSize() {
            return content.length();
        }


        @Override
        public String toString() {
            return "File { "+ "name : "+ getName() + " content :"+  getContent()  ;
        }


    }

    public static class Directory extends Entry {
        private String name;
        private List<Entry> entries;

        public Directory(String name){
            this.name = name;
            entries = new ArrayList<>();
        }

        @Override
        public boolean isFile() {
            return false;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getSize() {
            return 0;
        }

        private List<Entry> getEntries(){
            return entries;
        }

//        private void setEntries(){
//            entries.add();
//        }
    }

    public static void getDirectory(){
        Directory curr = root;
        for (Entry entry : curr.getEntries()){
            if (!entry.isFile()){
                System.out.println("Directory "+entry.getName());
            }
        }
    }

    public static void getFile(){
        Directory curr = root;
        for (Entry entry : curr.getEntries()){
            if (entry.isFile()){
                System.out.println("File "+entry.getName());
            }
        }
    }


    public static void main(String[] args){
        FileSystem fileSystem = new FileSystem();
        fileSystem.getRoot().getEntries().add(new File("File1.txt", "File 1 content"));
        fileSystem.getRoot().getEntries().add(new Directory("SubDir1"));
       // fileSystem.getRoot().getEntries().

        System.out.println(fileSystem.getRoot());
        System.out.println(fileSystem.getRoot().entries);
        getDirectory();
        getFile();
    }

}
