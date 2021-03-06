package patterns.DynamicProgramming.leetcode;



public class LongestArithSeqLength_1027 {
    public static int longestArithSeqLength(int[] A) {
        if (A.length<=2){
            return A.length;
        }
        return longestArithSeqLengthRecursive(A, -1 ,0, 0);
    }

    public static int longestArithSeqLengthRecursive(int[] A, int prevIndex, int currIndex,int diff){
        if (currIndex+1 > A.length-1){
            if (prevIndex > 0 && A[prevIndex]+diff == A[currIndex]){
              return  1;
            }
            return 0;
        }
        int c1 = 0;


        if (prevIndex==-1 || A[prevIndex]+diff == A[currIndex]){

           c1 = longestArithSeqLengthRecursive(A, currIndex,currIndex+1, diff)+1;

        } else {

            c1 = longestArithSeqLengthRecursive(A, prevIndex, currIndex+1, diff);
        }


        int c2 = longestArithSeqLengthRecursive(A, prevIndex, currIndex+1, prevIndex==-1 ? 0: A[currIndex+1]-A[prevIndex]);
        return Math.max(c1,c2);
    }
    public static void main(String[] args){
        int[] i1 = {3,6,7,9,12,15,18};
        int[] i2 = {9,4,7,2,10};
        int[] i3 = {25,20,1,2,15,3,10,8,7,8,0,9,10,11};

        int[][] in = { i1,i2,i3};
        for (int[] i : in){
            System.out.println("Result "+longestArithSeqLength(i));
        }
    }
}
