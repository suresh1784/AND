package algorithm.recursion;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Permutation {
    private static String result = null;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permutation(arr, res,list, 0);
       // System.out.println(res);

        String str = "abcde";
     //   stringPermutation("",str);

        int[] pre = new int[0];
      //  numberPerm(pre,arr, res,list, arr.length);
        System.out.println(res);

    }

    static void permutation(int[] arr, List<ArrayList<Integer>> res,ArrayList<Integer> list, int j){
        for (int i = j ; i< arr.length; i++){
         list.add(arr[i]);
         res.add(new ArrayList(list));
         permutation(arr, res,list,i+1);
         list.remove(list.size()-1);
        }
    }

    static void stringPermutation(String pre, String str){
        if (str.length() ==0){
            result = result + " : " + pre;
        }

        for (int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            String rest = str.substring(0,i) + str.substring(i+1);
            stringPermutation(pre+ch,rest);
        }
    }


    static void numberPerm(int[] pre, int[] arr, List<ArrayList<Integer>> res,ArrayList<Integer> list, int j){
        if (arr.length ==0 ){
            list.clear();
            for (int i : pre){
                list.add(i);
            }
            res.add(new ArrayList<>(list));
         //   System.out.println(res);

        }

        for (int i=0; i< arr.length; i++){
            int a = arr[i];
            int[] rest = con(Arrays.copyOfRange(arr, 0,i) ,Arrays.copyOfRange(arr, i+1,arr.length));
            numberPerm(con(pre, new int[]{a}),rest, res, list,j);
        }
    }

    static int[] con(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0;
        for (i=0; i < a.length; i++){
            c[i] = a[i];
        }

        for (int j=i , k =0; k<b.length; k++,j++ ){
            c[j] = b[k];
        }
        return c;

    }



}
