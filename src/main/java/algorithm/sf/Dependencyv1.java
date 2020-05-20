package algorithm.sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dependencyv1 {
    public static Map<String, List<String>> dependencyMap= new HashMap<>();
    public static Map<String, Integer> degreeMap = new HashMap<>();
    public static Set<String> install = new HashSet<>();

    static String executeCommand(String cmd) {
        StringBuilder sb  = new StringBuilder();
        String[] input = parseInput(cmd);
        String command = input[0];
        if (command.equals("DEPEND")){
            executeDependency(input[1], Arrays.copyOfRange(input, 2, input.length));
        } else if (command.equals("INSTALL")){
            sb.append(executeInstall(input[1]));
        } else if (command.equals("REMOVE")) {
            sb.append(executeRemove(input[1]));
        } else if (command.equals("END")) {
            dependencyMap= new HashMap<>();
            degreeMap = new HashMap<>();
            install = new HashSet<>();
        } else if (command.equals("LIST")){
            for (String install: install){
                sb.append("\n");
                sb.append(install);
            }
        }

        return sb.toString();
    }

    public static String[] parseInput(String cmd){
        String[] cmds = cmd.split(" ");
        return cmds;
    }

    public static String executeDependency(String source, String[] dependents) {
        StringBuilder sb = new StringBuilder();
        List<String> lists = new ArrayList<>();
        for (String dependent : dependents){
            lists.add(dependent);
        }
        dependencyMap.put(source, lists);
        return sb.toString();
    }


    public static String executeInstall(String source){
    return install(source);
    }

    public static String install(String source){
        StringBuilder sb  = new StringBuilder();
        if (install.contains(source)){
            sb.append("\n");
            sb.append(source +" is already installed");
        }else {
            if (degreeMap.get(source)== null) {
                degreeMap.put(source, 0);
            }
            if (dependencyMap.get(source)!= null){
                sb.append(installDependents(dependencyMap.get(source)));
            }
            sb.append("\n");
            sb.append(source + " successfully installed" );
            install.add(source);
        }
        return sb.toString();
    }


    public static String installDependents(List<String> dependents){
        StringBuilder sb  = new StringBuilder();
        for (String dependent : dependents){
            setOrIncDegreeMap(dependent);
            if (dependencyMap.get(dependent)!=null){
                sb.append(installDependents(dependencyMap.get(dependent)));
            }
            if (!install.contains(dependent)){
                sb.append("\n");
                sb.append(dependent+ " successfully installed" );
                install.add(dependent);
            }

        }
        return sb.toString();
    }



    public static void setOrIncDegreeMap(String source){
        if (degreeMap.get(source)!= null){
            degreeMap.put(source, degreeMap.get(source)+1);
        }else {
            degreeMap.put(source, 1);
        }
    }


    public static String executeRemove(String source){
        StringBuilder sb  = new StringBuilder();
        sb.append(removeNonDependency(source));
        return sb.toString();
    }

    public static String removeNonDependency(String source){
        StringBuilder sb  = new StringBuilder();
        if (degreeMap.get(source)!= null){
         if (degreeMap.get(source)==0){
             sb.append(remove(source));
         }else {
             install.add(source);
             sb.append("\n");
             sb.append(source+ " is still needed");
         }
        }
        return sb.toString();
    }

    public static String removeDependent(List<String> dependents){
        StringBuilder sb  = new StringBuilder();
        for (String dependent : dependents){
            degreeMap.put(dependent, degreeMap.get(dependent)-1);
            if ((degreeMap.get(dependent)== 0) && (install.contains(dependent))){
               sb.append(removeDependent(dependent));
            }
        }
        return sb.toString();
    }

    public static String removeDependent(String source){
        StringBuilder sb  = new StringBuilder();

        if (install.contains(source)){
            sb.append("\n");
            sb.append(source+ " is no longer needed");
            sb.append("\n");
            sb.append(source+ " successfully removed");
            install.remove(source);
            if (dependencyMap.get(source)!= null){
                sb.append(removeDependent(dependencyMap.get(source)));
            }
        }else {
            sb.append("\n");
            sb.append(source+" is not installed ");
        }

        return sb.toString();
    }

    public static String remove(String source){
        StringBuilder sb  = new StringBuilder();

        if (install.contains(source)){
            sb.append("\n");
            sb.append(source+ " successfully removed");
            install.remove(source);
            if (dependencyMap.get(source)!= null){
                sb.append(removeDependent(dependencyMap.get(source)));
            }
        }else {
            sb.append("\n");
            sb.append(source+" is not installed ");
        }

        return sb.toString();
    }

    public static void main(String[] args){
//        System.out.println(" ---------  DEPEND A B C - " + executeCommand("DEPEND A B C"));
//        System.out.println(" ---------  DEPEND D A E - " +executeCommand("DEPEND D A E"));
//        System.out.println(" ---------  INSTALL D - " +executeCommand("INSTALL D"));
//        System.out.println(" ---------  INSTALL D - " +executeCommand("REMOVE D"));

        System.out.println(" ---------  DEPEND TELNET TCPIP NETCARD - " + executeCommand("DEPEND TELNET TCPIP NETCARD"));
        System.out.println(" ---------  DEPEND TCPIP NETCARD - " +executeCommand("DEPEND TCPIP NETCARD"));
        System.out.println(" ---------  DEPEND DNS TCPIP NETCARD - " +executeCommand("DEPEND DNS TCPIP NETCARD"));
        System.out.println(" ---------  DEPEND BROWSER TCPIP HTML - " +executeCommand("DEPEND BROWSER TCPIP HTML"));
        System.out.println(" ---------  INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
        System.out.println(degreeMap.get("NETCARD"));
        System.out.println(" ---------  INSTALL TELNET - " +executeCommand("INSTALL TELNET"));

        System.out.println(degreeMap.get("NETCARD"));
        System.out.println(" ---------  INSTALL foo - " +executeCommand("INSTALL foo"));
        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" ---------  INSTALL BROWSER - " +executeCommand("INSTALL BROWSER"));
        System.out.println(" ---------  INSTALL DNS - " +executeCommand("INSTALL DNS"));

        System.out.println(degreeMap.get("NETCARD"));
        System.out.println(" ---------  LIST- " +executeCommand("LIST"));
        System.out.println(" ---------  REMOVE TELNET - " +executeCommand("REMOVE TELNET"));
        System.out.println("Remove Telnet "+degreeMap.get("NETCARD"));
        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" ---------  REMOVE DNS - " +executeCommand("REMOVE DNS"));
        System.out.println("Remove dns "+degreeMap.get("NETCARD"));
        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
        System.out.println(" ---------  INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
        System.out.println(" ---------  REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
        System.out.println("Remove tcpip "+degreeMap.get("NETCARD"));
        System.out.println(" ---------  REMOVE BROWSER - " +executeCommand("REMOVE BROWSER"));
        System.out.println(" ---------  REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
        System.out.println(" ---------  LIST- " +executeCommand("LIST"));
        System.out.println(" ---------  END - " +executeCommand("END"));
//
//        System.out.println(" ---------  DEPEND TELNET TCPIP NETCARD - " + executeCommand("DEPEND TELNET TCPIP NETCARD"));
//        System.out.println(" ---------  DEPEND TCPIP NETCARD - " +executeCommand("DEPEND TCPIP NETCARD"));
//        System.out.println(" ---------  DEPEND DNS TCPIP NETCARD - " +executeCommand("DEPEND DNS TCPIP NETCARD"));
//        System.out.println(" ---------  DEPEND BROWSER TCPIP HTML - " +executeCommand("DEPEND BROWSER TCPIP HTML"));
//        System.out.println(" ---------  INSTALL foo - " +executeCommand("INSTALL foo"));
//        System.out.println(" ---------  DEPEND NETCARD BROWSER - " +executeCommand("DEPEND NETCARD BROWSER"));
//        System.out.println(" ---------  DEPEND BROWSER2 TCPIP HTML - " +executeCommand("DEPEND BROWSER2 TCPIP HTML"));
//        System.out.println(" ---------  INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
//        System.out.println(" ---------  INSTALL TELNET - " +executeCommand("INSTALL TELNET"));
//        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
//        System.out.println(" ---------  INSTALL BROWSER " +executeCommand("INSTALL BROWSER"));
//        System.out.println(" ---------  INSTALL DNS - " +executeCommand("INSTALL DNS"));
//        System.out.println(" ---------  LIST - " +executeCommand("LIST"));
//        System.out.println(" ---------  REMOVE TELNET - " +executeCommand("REMOVE TELNET"));
//        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
//        System.out.println(" ---------  REMOVE DNS - " +executeCommand("REMOVE DNS"));
//        System.out.println(" ---------  REMOVE NETCARD - " +executeCommand("REMOVE NETCARD"));
//        System.out.println(" ---------  INSTALL NETCARD - " +executeCommand("INSTALL NETCARD"));
//        System.out.println(" ---------  REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
//        System.out.println(" ---------  REMOVE BROWSER - " +executeCommand("REMOVE BROWSER"));
//        System.out.println(" ---------  REMOVE TCPIP - " +executeCommand("REMOVE TCPIP"));
//        System.out.println(" ---------  END - " +executeCommand("END"));

    }
}
