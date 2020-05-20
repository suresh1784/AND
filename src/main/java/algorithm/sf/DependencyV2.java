package algorithm.sf;

import java.util.*;

public class DependencyV2 {

    public static Map<String, List<String>> dependencyMap= new HashMap<>();
    public static Map<String, Integer> degreeMap = new HashMap<>();
    public static Set<String> installSet = new HashSet<>();

    public static String executeCommand(String cmd){
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
            installSet = new HashSet<>();
        } else if (command.equals("LIST")){
            for (String install: installSet){
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
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()){
            String top = queue.poll();
            if (!installSet.contains(top)){
                sb.append("\n");
                sb.append(top + " successfully installed" );
                installSet.add(top);
                if (degreeMap.get(top)==null){
                    degreeMap.put(top, 0);
                }
                if (dependencyMap.get(top)!=null){
                    List<String> dependents = dependencyMap.get(top);
                    for (String dependent : dependents){
                        if (degreeMap.get(dependent)!=null) {
                            degreeMap.put(dependent, degreeMap.get(dependent) + 1);
                        }else {
                            degreeMap.put(dependent,  1);
                        }
                       if (!installSet.contains(dependent)){
                           queue.offer(dependent);
                       }
                    }

                }
            }else {
                if (source == top) {
                    sb.append("\n");
                    sb.append(top + " is already installed");
                }
            }
        }



        return sb.toString();
    }


    static String executeRemove(String source){
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()){
            String top = queue.poll();

            if (degreeMap.get(top)==0 && installSet.contains(top)){
                if (source == top){
                    sb.append("\n");
                    sb.append(top+ " successfully removed");
                    installSet.remove(top);
                }else {
                    sb.append("\n");
                    sb.append(top+ " is no longer needed");
                    sb.append("\n");
                    sb.append(top+ " successfully removed");
                    installSet.remove(top);
                }

                if (dependencyMap.get(top)!=null) {
                    List<String> dependents = dependencyMap.get(top);
                    for (String dependent : dependents){
                        degreeMap.put(dependent, degreeMap.get(dependent)-1);
                        if (degreeMap.get(dependent)==0){
                            queue.offer(dependent);
                        }
                    }
                }
            } else if (degreeMap.get(top)==0 || installSet.contains(top)){
                if (source == top) {
                    if (!installSet.contains(top)){
                        sb.append("\n");
                        sb.append(top+" is not installed ");
                    }else if (degreeMap.get(top)>= 1) {
                        sb.append("\n");
                        sb.append(top+ " is still needed");
                    }
                }
            }

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
