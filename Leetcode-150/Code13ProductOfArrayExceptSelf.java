import java.util.*;

public class Code13ProductOfArrayExceptSelf {

    public static int[] solve2(int[] nums) {

        int size = nums.length;

        // LEFT PRODUCT
        int[] left = new int[size];
        for(int i = 0 ; i < size ; i++) {
            if(i == 0)
                left[i] = 1;
            else    
                left[i] = left[i-1] * nums[i-1];
        }
        
        int[] ans = new int[size];
        int rightProduct = 1;

        for(int i = size-1 ; i >= 0 ; i--) {
            ans[i] = left[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return ans;
    }

    public static int[] solve1(int[] nums) {

        int size = nums.length;

        // left product 
        int[] left = new int[size];
        for(int i = 0 ; i < size ; i++) {
            if(i == 0) 
                left[i] = 1;
            else
                left[i] = nums[i-1] * left[i-1];
        }

        // right product
        int[] right = new int[size];
        for(int i = size-1 ; i >= 0 ; i--) {
            if(i == size-1)
                right[i] = 1;
            else
                right[i] = nums[i+1] * right[i+1];
        }

        int[] ans = new int[size];
        for(int i = 0 ; i < size ; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;

    }

    public static int[] solve(int[] nums) {

        int prdct = 1;
        int[] ans = new int[nums.length];

        for(int i : nums)
            prdct = prdct * i;

        if(prdct == 0) {

            for(int i = 0 ; i < nums.length ; i++) {

                if(nums[i] == 0) {

                    int prdct1 = 1;
                    for(int j = 0 ; j < nums.length ; j++) {
                        if(i != j)
                            prdct1 = prdct1 * nums[j];
                    }

                    ans[i] = prdct1;
                }


            }

            return ans;

        }    

        int prdct1 = prdct;

        for(int i = 0 ; i < nums.length ; i++) {

            ans[i] = prdct1 / nums[i];
            prdct1 = prdct;

        }

        return ans;

    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        int[] ans = solve(nums);
        System.out.println(Arrays.toString(ans));

    }
}
