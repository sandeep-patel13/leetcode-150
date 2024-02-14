public class Code28MinLengthSubarray {
    public static int solve(int[] nums , int target) {
        int sum = 0 , left = 0 , right = 0, minLen = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            if(sum >= target) {
                while(sum >= target) {
                    sum -= nums[left];
                    left++;
                }
                minLen = Math.min(minLen , (right-left+2));
            }
            right++;
        }
        return minLen;
    }
    public static void main(String[] args) {
        int nums[] = {2 , 3 , 1 , 1 , 7 ,3};
        int target = 10;
        int minLength = solve(nums, target);
        System.out.println("minLength : "+minLength);
    }
}
