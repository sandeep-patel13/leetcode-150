import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {

    static boolean isSafe(int newRow , int newCol, int[][] maze , int[][] visited , int n) {

        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {

            if(visited[newRow][newCol] == 0 && maze[newRow][newCol] == 1) {

                return true;

            } 

        }

        return false;

    }

    static void solve(int[][] maze , int[][]visited , ArrayList<String>ans , String output , int row , int col , int n) {


        // base case 
        if(row == n - 1 && col == n-1){
            ans.add(output);
            return;
        }

        // jaise hi kisi (row , col) me aana use visited bana do  
        visited[row][col] = 1;

        // 4 choices 

        // down 
        int newRow = row + 1;
        int newCol = col;
        if(isSafe(newRow , newCol , maze , visited , n)) {

            output = output + "D";
            solve(maze, visited, ans, output, newRow, newCol, n);

            // removing last character 
            output = output.substring(0, output.length()-1);

        }

        // left 
        newRow = row;
        newCol = col - 1;
        if(isSafe(newRow , newCol , maze , visited , n)) {

            output = output + "L";
            solve(maze, visited, ans, output, newRow, newCol, n);

            // removing last character 
            output = output.substring(0, output.length()-1);

        }

        // right 
        newRow = row;
        newCol = col + 1;
        if(isSafe(newRow , newCol , maze , visited , n)) {

            output = output + "R";
            solve(maze, visited, ans, output, newRow, newCol, n);

            // removing last character 
            output = output.substring(0, output.length()-1);

        }


        // up 
        newRow = row - 1;
        newCol = col ;
        if(isSafe(newRow , newCol , maze , visited , n)) {

            output = output + "U";
            solve(maze, visited, ans, output, newRow, newCol, n);

            // removing last character 
            output = output.substring(0, output.length()-1);

        }

        // BACKTRACK
        visited[row][col] = 0;

    }


    static ArrayList<String> findPath(int[][]maze , int n) {

        ArrayList<String> ans = new ArrayList<>();

        if(maze[0][0] == 0)
            return ans;
        

        int row = 0 , col = 0;

        
        int[][] visited = new int[n][n];

        String output = "";
        
        solve(maze , visited , ans , output, row , col , n);

        return ans;
    }

    public static void main(String[] args) {
        
        int[][] maze = new int[][]{{1 , 0 , 0 , 0} , 
                                   {1 , 1 , 0 , 1} ,
                                   {1 , 1 , 0 , 0} ,
                                   {0 , 1 , 1 , 1}
                                };

        for(int i = 0 ; i < maze.length ; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        

        ArrayList<String> ans = findPath(maze , 4);

        System.out.println(ans);

    }
}
