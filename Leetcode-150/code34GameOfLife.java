import java.util.Arrays;
public class code34GameOfLife {

    public static int getCount(int[][] board , int row , int col , int m , int n) {
        
        int startRow = row-1 , endRow = row+1;
        int startCol = col-1 , endCol = col+1;
        int count = 0;
        for(int i = startRow ; i <= endRow ; i++) {
            if(i >= 0 && i < m) {
                for(int j = startCol ; j <= endCol ; i++) {
                    if(j >= 0 && j < n) {
                        if((i != row) || (j != col)){
                            if(board[i][j] == 1)
                                count++;
                        }
                    }
                }
            }
        }
        return count;

    }
    
    public static void solve(int[][] board){

        int m = board.length , n = board[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                int count = getCount(board , i , j , m , n);
                int val = board[i][j];
                if(val == 1){
                    if(count < 2)
                        ans[i][j] = 0;
                    else if(count == 2 || count == 3)
                        ans[i][j] = 1;
                    else 
                        ans[i][j] = 0;
                }
                else 
                    ans[i][j] = (val == 3) ? 1 : 0;
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = ans[i][j];
            }
        }

    } 
    
    public static void solve1(int[][] board){

        int m = board.length , n = board[0].length;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                int count = getCount(board , i , j , m , n);
                int val = board[i][j];
                if(val == 1){
                    if(count < 2 || count > 3)
                        board[i][j] = 3;
                }
                else {
                    if(count == 3)
                        board[i][j] = 2;
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

    } 

    public static void main(String[] args) {
        int[][] board = {{0,1,0} , {0,0,1} , {1,1,1} , {0,0,0}};
        solve(board);
        for(int[] row : board)
            System.out.println(Arrays.toString(row));
    }
}
