package algorithm.leetcode;

public class MaxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] LA = new int[A.length];
        int[] MA = new int[A.length];

        int[] mLA = new int[A.length];
        int[] mMA = new int[A.length];
        int l1 = 0 ;
        int l2 = 0 ;
        int max1 = 0 ;
        int max2 = 0 ;
        for (int r = 0 ; r < A.length ; r++){
            if (r-l1 < L) {
                LA[r] = r==0 ? A[r] : LA[r - 1] + A[r];
                max1 = Math.max(max1, LA[r]);
                mLA[r] = max1;
            } else {
                LA[r] = LA[r - 1] + A[r];
                LA[r] -= A[l1];
                max1 = Math.max(max1, LA[r]);
                mLA[r] = max1;
                l1++;
            }

            if (r-l2 < M) {
                MA[r] = r==0 ? A[r] : MA[r - 1] + A[r];
                max2 = Math.max(max2, MA[r]);
                mMA[r] = max2;
            } else {
                MA[r] = MA[r - 1] + A[r];
                MA[r] -= A[l2];
                max2 = Math.max(max2, MA[r]);
                mMA[r] = max2;
                l2++;
            }
        }



        int[] LB = new int[A.length];
        int[] MB = new int[A.length];
        int[] mLB = new int[A.length];
        int[] mMB = new int[A.length];
        l1 = A.length -1 ;
        l2 = A.length -1;
        max1 = 0 ;
        max2 = 0 ;
        for (int r = A.length-1 ; r >= 0 ; r--){
            if (l1-r < L) {
                LB[r] = r==A.length-1 ? A[r] : LB[r + 1] + A[r];
                max1 = Math.max(max1, LB[r]);
                mLB[r] = max1;
            } else {
                LB[r] = LB[r + 1] + A[r];
                LB[r] -= A[l1];
                max1 = Math.max(max1, LB[r]);
                mLB[r] = max1;
                l1--;
            }

            if (l2-r < M) {
                MB[r] = r==A.length-1 ? A[r] : MB[r + 1] + A[r];
                max2 = Math.max(max2, MB[r]);
                mMB[r] = max2;
            } else {
                MB[r] = MB[r + 1] + A[r];
                MB[r] -= A[l2];
                max2 = Math.max(max2, MB[r]);
                mMB[r] = max2;
                l2--;
            }
        }
        int sum = 0 ;
        int currSum1 = 0 ;
        int currSum2 = 0 ;
        for (int i = 0 ; i < A.length ; i++){

           currSum1 =  Math.max(currSum1, i< A.length-1 ? mLA[i]+mMB[i+1] :mLA[i] );
            currSum2 =  Math.max(currSum2, i< A.length-1 ? mMA[i]+mLB[i+1] :mMA[i] );
            sum = Math.max (sum, Math.max(currSum1, currSum2));
        }
        return sum;
    }
}
