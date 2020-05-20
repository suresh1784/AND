package algorithm.karat;

public class MaxSquareSubMatrix {

    public static void main(String args[]){

        int arr[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}};

        int result = maxSize(arr);
        System.out.print(result);
    }


    static int maxSize(int[][] arr){
        int maxArea = 0 ;
        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0 ; i < m; i++){
            for (int j = 0 ; j < n ; j++){
                if (arr[i][j]==0){
                    continue;
                }

                if (i == 0 || j ==0){
                    if (arr[i][j]==1){
                        arr[i][j] = 1;
                        maxArea = Math.max(maxArea, 1);
                    }
                }else {
                    arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i][j-1], arr[i-1][j-1] ))+1;
                    if (arr[i][j]>maxArea) {
                        maxArea = Math.max(maxArea, arr[i][j]);
                        System.out.println("i--- " + i);
                        System.out.println("j--- " + j);
                    }

                }
            }
        }

        return maxArea;

    }
}
