package algorithm.leetcode;

import java.sql.SQLOutput;
import java.util.*;

public class TestEditor {


    public static String newTextEditor(List<String> operations){
        StringBuilder sb = new StringBuilder();
        String prevOperation = null;
        String prevCmd = null;
        String copyText = null;
        String deleteTxt = null;
        Stack<String> stack = new Stack<>();

        for (String operationCmd : operations) {

            System.out.println("---> "+operationCmd);
            String[]  operationsArray = operationCmd.split(" ");
            String operation = operationsArray[0];
            // INSERT test
            if (operation.equalsIgnoreCase("INSERT")) {
                prevOperation = "INSERT";
                prevCmd = operationCmd;
                String text = operationsArray[1];
                sb.append(text);
                stack.push(operationCmd);
            }
            // DELETE  -> last character
            if (operation.equalsIgnoreCase("DELETE")) {
                prevCmd = operationCmd;
                prevOperation = "DELETE";
                deleteTxt = sb.charAt(sb.length()-1)+"";
                 sb.deleteCharAt(sb.length()-1);
                stack.push(operationCmd+" "+deleteTxt);
            }

            // UNDO
            if (operation.equalsIgnoreCase("UNDO")) {
                String cmd1 = stack.pop();
                String[] cmdArr = cmd1.split(" ");
                prevOperation = cmdArr[0];

                if (prevOperation.equals("INSERT")) {
                    // do delete
                    prevCmd = cmdArr[1];
                    String textToDelete = prevCmd;
                    int lastIndex = sb.length();
                    int startIndex = lastIndex-textToDelete.length();

                    sb = new StringBuilder(sb.substring(0, startIndex));


                }else if (prevOperation.equals("DELETE")){
                    // to insert
                    deleteTxt = cmdArr[1];
                    sb.append(deleteTxt);

                }else if (prevOperation.equals("PASTE")){
                    String textToDelete =  cmdArr[1];
                    int lastIndex = sb.length();
                    int startIndex = lastIndex-textToDelete.length();

                    sb = new StringBuilder(sb.substring(0, startIndex));

                }else if (prevOperation.equals("UNDO")){

                }
                prevOperation = "UNDO";
                prevCmd = operationCmd;
            }

            // PASTE -> copy the one in clipboard
            if (operation.equalsIgnoreCase("PASTE")) {
                prevOperation = "PASTE";
                prevCmd = operationCmd;
                if (copyText!= null){
                    sb.append(copyText);
                }
                stack.push(operationCmd+" "+copyText);
            }

            // COPY index
            if (operation.equalsIgnoreCase("COPY")) {
              //  prevOperation = "COPY";
              //  prevCmd = operationCmd;
                String text = operationsArray[1];
                int index = Integer.parseInt(text);
                copyText = sb.substring(index);
            }
            System.out.println(sb);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        List<String> in1 = new ArrayList<>();
        in1 = Arrays.asList( "INSERT Code", "INSERT Signal", "DELETE", "UNDO");
        System.out.println(in1+" -> "+newTextEditor(in1));

        List<String> in2 = new ArrayList<>();
        in2 = Arrays.asList( "INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam");
        System.out.println(in2+" -> "+newTextEditor(in2));
    }
}
