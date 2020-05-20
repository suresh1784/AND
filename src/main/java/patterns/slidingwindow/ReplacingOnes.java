package patterns.slidingwindow;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int left = 0 ;
        int right = 0;

        int maxLength = 0 ;
        int count = 0 ;

        while (right < arr.length){
            int num = arr[right];
            if (num==0){
                count++;
            }

            while (count > k){
                maxLength = Math.max(maxLength, right-left);
               // System.out.println("left "+left + " right "+right + " maxLen "+maxLength);
                int num1 = arr[left];
                left++;
                if (num1==0){
                    count--;
                }
            }

            right ++;
        }// while
        maxLength = Math.max(maxLength, right-left);
        return maxLength;
    } // findLength

    public static int findLengthv1(int[] arr, int k) {
        int left = 0 ;
        int right = 0;

        int maxLength = 0 ;
        int count = 0 ;

        while (right < arr.length){
            int num = arr[right];
            if (num==1){
                count++;
            }

            while (right-left+1 - count > k){

                if (arr[left]==1){
                    count--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right ++;
        }// while
        return maxLength;
    } // findLengthv1

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
        System.out.println(ReplacingOnes.findLengthv1(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLengthv1(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }

}
