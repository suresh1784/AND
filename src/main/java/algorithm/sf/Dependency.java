package algorithm.sf;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Dependency {

    public static enum Commands {
        DEPEND,
        INSTALL,
        REMOVE,
        LIST,
        END

    }

    public static Map<String, List<String>> dependencyMap= new HashMap<>();
    public static Map<String, Integer> degreeMap = new HashMap<>();
    public static Map<String, String> install = new HashMap<>();


    static String executeCommand(String cmd){
        StringBuilder sb  = new StringBuilder();
        String[] cmds = cmd.split(" ");
        String command = cmds[0];

        if (command.equals("DEPEND")){
            String source = cmds[1];

            List<String> list = new ArrayList<>();

            for (int i = 2; i < cmds.length; i++){
              list.add(cmds[i]);

            }
            dependencyMap.put(source, list);
        }else if (command.equals("INSTALL")){
            String source = cmds[1];
            if (install.containsKey(source)){
                sb.append("\n");
                sb.append(source +" is already installed");
            }else {
                if (dependencyMap.get(source)!=null) {

                    List<String> lists = dependencyMap.get(source);
                    for (String list : lists) {
                        if (!install.containsKey(list)) {
                            sb.append("\n");
                            sb.append("Installing " + list);
                            install.put(list, "dependent");
                        }
                            if (degreeMap.get(list) == null){
                                degreeMap.put(list, 1);
                            }else {
                                degreeMap.put(list, degreeMap.get(list)+1);
                            }

                    }
                }
                sb.append("\n");
                if (degreeMap.get(source)== null){
                    degreeMap.put(source, 0);
                }
                install.put(source,"independent");
                sb.append("Installing " + source);

            }

        }else if (command.equals("REMOVE")){
            String src = cmds[1];
            if (degreeMap.get(src)!= null){
                int degree = degreeMap.get(src);
                if (degree == 0 ){
                    if (install.containsKey(src)){
                        sb.append("\n");
                        sb.append("Removing "+src);
                        install.remove(src);
                    } else {
                        sb.append("\n");
                        sb.append(src + " is not installed");
                    }
                    if (dependencyMap.get(src)!= null) {
                        List<String> lists = dependencyMap.get(src);
                        for (String list : lists) {
                            degreeMap.put(list, degreeMap.get(list) - 1);
                            if (degreeMap.get(list) == 0 && install.get(list) != null && install.get(list).equals("dependent")) {
                                sb.append("\n");
                                sb.append("Removing " + list);
                                install.remove(list);
                            }

                        }
                    }
                }else if (degree >= 1){
                    install.put(src,"dependent");
                    sb.append("\n");
                    sb.append(src + " is still needed");
                }
            }else if (install.containsKey(src)){
                sb.append("\n");
                sb.append("Removing "+src);
                install.remove(src);
            } else {
                sb.append("\n");
                sb.append(src + " is not installed");
            }

        }else if (command.equals("LIST")){
            for (String install : install.keySet()){
                sb.append("\n");
                sb.append(install);
            }
        }else if (command.equals("END")) {
            dependencyMap= new HashMap<>();
            degreeMap = new HashMap<>();
            install = new HashMap<>();
        }


        return sb.toString();
    }




    public static void main(String[] args){
        System.out.println(" DEPEND TELNET TCPIP NETCARD - " + executeCommand("DEPEND TELNET TCPIP NETCARD"));
        System.out.println(" DEPEND TCPIP NETCARD - " +executeCommand("DEPEND TCPIP NETCARD"));
        System.out.println(" DEPEND DNS TCPIP NETCARD - " +executeCommand("DEPEND DNS TCPIP NETCARD"));
        System.out.println(" DEPEND BROWSER TCPIP HTML - " +executeCommand("DEPEND BROWSER TCPIP HTML"));
        System.out.println(" INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
        System.out.println(" INSTALL TELNET - " +executeCommand("INSTALL TELNET"));
        System.out.println(" INSTALL foo - " +executeCommand("INSTALL foo"));
        System.out.println(" REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" INSTALL BROWSER - " +executeCommand("INSTALL BROWSER"));
        System.out.println(" INSTALL DNS - " +executeCommand("INSTALL DNS"));
        System.out.println(" LIST- " +executeCommand("LIST"));
        System.out.println(" REMOVE TELNET - " +executeCommand("REMOVE TELNET"));
        System.out.println(" REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" REMOVE DNS - " +executeCommand("REMOVE DNS"));
        System.out.println(" REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
        System.out.println(" REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
        System.out.println(" REMOVE BROWSER - " +executeCommand("REMOVE BROWSER"));
        System.out.println(" REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
        System.out.println(" END - " +executeCommand("END"));
    }
}
