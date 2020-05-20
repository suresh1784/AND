package algorithm.leetcode;

public class _5369 {
    public static int numTeams(int[] rating) {
        int len = rating.length;
        int count = 0 ;
        for (int i = 0 ; i < len-2; i++){
            for (int j = i+1;j < len-1; j++){
                for (int k = j+1; k < len ; k++){
                    if (rating[i]<rating[j] && rating[j]<rating[k]){
                        count++;
                    }

                    if (rating[i]>rating[j] && rating[j]> rating[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
       int[]  rating = {2,1,3};
        System.out.println(numTeams(rating));

    }
}
