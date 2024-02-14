
public class Code26MaxWater {

    public static int maxWater(int[] heights) {
        
        int maxWaterAmount = 0 , left = 0 , right = heights.length-1;
        while(left < right) {
            int curWaterAmount = Math.min(heights[left], heights[right]) * (right - left);
            maxWaterAmount = Math.max(maxWaterAmount , curWaterAmount);
            if(heights[left] < heights[right])
                left++;
            else 
                right--;
        }
        return maxWaterAmount;

    }

    public static void main(String[] args) {
        int[] heights = {2 , 7 , 11 , 15};
        int maxWaterAmount = maxWater(heights);
        System.out.println(maxWaterAmount);

    }
}
