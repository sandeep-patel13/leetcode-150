import java.util.ArrayList;
import java.util.List;

public class Code32SpiralMatrix {
    public static List<Integer> solve(int[][]matrix) {
        int left = 0 , right = matrix[0].length-1;
        int top = 0 , bottom = matrix.length-1;
        List<Integer> ans = new ArrayList<>();
         
        // IF MINIMUM ONE ROW AND ONE COLUMN IS TO BE PRINTED, PROCESS IT... 
        while(top <= bottom && left <= right) {
            for(int i = left ; i <= right ; i++)
                ans.add(matrix[top][i]);
            bottom++;

            for(int i = top ; i <= bottom ; i++) 
                ans.add(matrix[i][right]);
            right--;

            // IF THERE IS MINIMUM ONE ROW , PROCESS IT... 
            if(top <= bottom){
                for(int i = right ; i >= left ; i--)
                    ans.add(matrix[bottom][i]);
                top--;
            }

            // IF THERE IS MINIMUM ONE COLUMN , PROCESS IT... 
            if(top <= bottom){
                for(int i = bottom ; i >= top ; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = solve(matrix);
    }
}
