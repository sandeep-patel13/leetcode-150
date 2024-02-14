import java.util.Arrays;

public class Code15CandyDistribution {

    public static int distribute(int[] nums) {

        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left , 1);
        Arrays.fill(right, 1);

        // left 
        for(int i = 1 ; i < size ; i++) {
            if(nums[i] > nums[i-1])
                left[i] = left[i-1] + 1;
        }

        // right 
        for(int i = size-2 ; i >= 0; i--) {
            if(nums[i] > nums[i+1])
                right[i] = right[i+1] + 1;
        }

        int minCandy = 0;
        for(int i = 0 ; i < size ; i++) {
            minCandy += Math.max(left[i], right[i]);
        }

        return minCandy;
        
    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        int minCandy = distribute(nums);
        // System.out.println(Arrays.toString(minCandy));

    }
}
