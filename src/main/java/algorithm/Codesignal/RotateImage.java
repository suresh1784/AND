package algorithm.Codesignal;

public class RotateImage {
    public static void main(String[] args) {
        int[][] in = {{1,2,3}, {4,5,6},{7,8,9}};
        printArray(in, "Input matrix");
        printArray(secDiagonal(in), "Sec Diagonal");
    }

//    00 01 02
//    10 11 12
//    20 21 22

    static int[][] secDiagonal(int[][] matrix){
        int m = matrix.length;
        int len = m-1;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < m; j++){
                if (i+j<len){

                int temp = matrix[i][j];
                int ival = len-i;
                int jval = len-j;
                int i1 = i+ival;
                int j1 = j+jval;
                System.out.println("");
                System.out.println("i ->  "+i + " j->  "+j);
                System.out.println("i+val ->  "+i1 + " j+val->  "+j1);

                matrix[i][j] = matrix[jval][ival];
                matrix[jval][ival] = temp;

                }
            }
          //  printArray(matrix, "i "+i);
        }
       return matrix;
    }

    static void printArray(int[][] matrix, String msg){
        System.out.println(msg);
        int m = matrix.length;
        for (int i = 0 ; i < m ; i++){
            System.out.println("");
            for (int j = 0 ; j < m ; j++){
                System.out.printf(" "+matrix[i][j]);
            }
        }
    }

}
