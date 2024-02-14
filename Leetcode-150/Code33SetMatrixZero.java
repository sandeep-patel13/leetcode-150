import java.util.Arrays;

public class Code33SetMatrixZero {

    public static boolean[][] mapping;

    public static void makeEntireRow(int[][] matrix , int row , int col) {
        for (int i = 0; i < matrix.length; i++)
                mapping[i][col] = true;
    }

    public static void makeEntireColumn(int[][] matrix , int row , int col) {
        for (int i=0 ; i<matrix[0].length ;i++)
            mapping[row][i] = true;
    }

    public static void solve(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        mapping = new boolean[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(matrix[i][j] == 0) {
                    makeEntireRow(matrix , i , j);
                    makeEntireColumn(matrix , i , j);
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) 
                if(mapping[i][j] == true)
                    matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1 , 1 , 1},
                            {1 , 0 , 1},
                            {1 , 1 , 1}
                        };
                
            solve(matrix);
            
            for(int i = 0 ; i < matrix.length ; i++) 
                System.out.println(Arrays.toString(matrix[i]));
        }
}