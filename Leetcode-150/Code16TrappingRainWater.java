// import java.util.Arrays;

// public class Code16TrappingRainWater {

//     public static int solve(int[] heights) {

//         int totalWater = 0;

//         for(int i = 1 ; i < heights.length ; i++) {

//             // get the left max height 
//             int maxLeftHeight = getMaxLeftHeight(heights, i);

//             // get the right max height 
//             int maxRightHeight = getMaxRightHeight(heights, i);

//             // water level 
//             int wl = Math.min(maxLeftHeight , maxRightHeight);

//             int diff = 0;

//             if(wl > heights[i]) 
//                 diff = wl - heights[i];
            
//             totalWater += diff;

//         }

//     }

//     public static void main(String[] args) {
        
//         int[] nums = {2,3,1,1,4};
//         int totalWater = solve(nums);
//         System.out.println(totalWater);

//     }
// }
