import java.util.Arrays;

public class Code6RotateArray {

    public static void shifting(int[] nums) {

        int x = nums[nums.length - 1];

        // nums.length - 1 to 1
        for(int i = nums.length - 1 ; i > 0 ; i--) {
            nums[i] = nums[i-1];
        } 

        nums[0] = x;

    }

    // TIME LIMIT EXCEED 
    public static void rotateArray3(int[] nums , int k) {

        if(nums.length == 0 || nums.length == 1)
            return;

        while(k > nums.length)
            k = k % nums.length;

        for(int i = 0 ; i < k ; i++)
            shifting(nums);

    }

    public static void rotateArray4(int[] nums , int k) {

        if(nums.length == 0 || nums.length == 1)
            return;

        // keep taking modulo till k becomes less or equal to nums.length
        while(k > nums.length) 
            k = k % nums.length;

        int[] answer = new int[nums.length]; 

        int n = nums.length;

        // copying elements of 0th index to [n-k-1]th index into ans  
        for(int i = 0 ; i < n-k ; i++)
            answer[i+k] = nums[i];

        // copying last k elements 
        for(int i = 0 ; i < k ; i++) 
            answer[i] = nums[n-k+i];

        for(int i = 0 ; i < n ; i++) 
            nums[i] = answer[i];

    }

    public static void rotateArray2(int[] nums , int k) {

        if(nums.length == 0 || nums.length == 1)
            return;

        // keep taking modulo till k becomes less or equal to nums.length
        while(k > nums.length) 
            k = k % nums.length;

        int index = nums.length - k;

        int[] answer = new int[nums.length];
        int j = 0;

        // copying element from index to nums.length-1
        for(int i = index ; i < nums.length ; i++) 
            answer[j++] = nums[i];

        // copying element from 0 to index 
        for(int i = 0 ; i < index ; i++) 
            answer[j++] = nums[i];

        // copying answer to nums again 
        for(int i = 0 ; i < nums.length ; i++)
            nums[i] = answer[i];

    }

    public static void rotateArray1(int[] nums , int k) {

        int[] answer = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++) {

            System.out.println(Arrays.toString(answer));
            if(i > k) 
                answer[ (i + k) - nums.length ] = nums[i];

            else 
                answer[i+k] = nums[i];
        }

    }

    public static void rotateArray(int[] nums , int k) {

        int[] answer = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++) {

            answer[ (i + k) % nums.length] = nums[i];

        }

        for(int i = 0 ; i < nums.length ; i++) 
            nums[i] = answer[i];

    }

    public static void main(String[] args) {
        
        int[] nums = {1 , 2 , 3 , 4 , 5 , 6, 7};
        rotateArray1(nums , 3);
        System.out.println(Arrays.toString(nums));

    }
}
