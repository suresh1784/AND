package algorithm.leetcode;

public class Bigram {
    public static String[] findOcurrences(String text, String first, String second) {
    String result = null;
    String[] input = text.split(" ");
    for (int i = 0 ; i+2 < input.length; i++){
        if (input[i].equals(first) && input[i+1].equals(second) ){
            if (result == null){
              result = input[i+2];
            }else {
                result = result + ":" + input[i + 2];
            }
        }
    }
    if (result != null){
        if (result.contains(":")){
           return result.split(":");
        }else {
            String[] temp = new String[]{ result };
            return temp;
        }
    }
        String[] temp1 = new String[]{};
    return temp1 ;
    }

    public static void main (String[] args){
//        String text = "alice is a good girl she is a good student";
//                String first = "a" ;
//                String second = "good";


//       String  text = "we will we will rock you";
//         String       first = "we";
//          String      second = "will";

        String  text =  "obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre";
        String       first = "jnvavldde";
        String      second = "y";
        String[] result = findOcurrences(text,first,second);
        System.out.println(result);
    }
}
