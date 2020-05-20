package algorithm.onlineassesment.amazon;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int rowStart = 0 ;
        int colStart = 0 ;
        int rowEnd = n-1;
        int colEnd = n-1;
        int[][] matrix = new int[n][n];
        int count = 0 ;
        while (rowStart <=rowEnd && colStart <=colEnd){
            for (int i = colStart ; i <=colEnd ; i++){
                matrix[rowStart][i] = ++count;
            }
            rowStart++;

            for (int i = rowStart; i <=rowEnd ; i++){
                matrix[i][colEnd] = ++count;
            }
            colEnd--;

            for (int i = colEnd ; i >=colStart ; i--){
                matrix[rowEnd][i]= ++count;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart ; i--){
                matrix[i][colStart] = ++count;
            }
            colStart++;
        }
        return matrix;
    }
}
