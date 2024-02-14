public class Code9JumpGame {

    public static boolean jumpGame(int[] nums) {

        int maximumReachable = 0;

        for(int reachable = 0 ; reachable < nums.length ; reachable++) {

            if(maximumReachable < reachable)
                return false;

            maximumReachable = Math.max(maximumReachable , reachable + nums[reachable]);

        }

        return true;

    }

    public static boolean jumpGame1(int[] nums) {

        int lastJump = nums.length-1;

        for(int i = lastJump-1 ; i >= 0 ; i--) {

            if(nums[i] >= lastJump - i)
                lastJump = i;

        }

        return 0 == lastJump;

    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        boolean ans = jumpGame(nums);
        System.out.println(ans);

    }
}
