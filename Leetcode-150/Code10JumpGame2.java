public class Code10JumpGame2 {

    public static int jumpGame(int[] nums) {

        // we are jumping on a WINDOW each time , NOT on particlular ELEMENT ... 

        int totalJumps = 0;
        int destination = nums.length-1;
        int coverage = 0 , lastJumpingIndex = 0;

        if(nums.length == 1)
            return 0;

        for(int i = 0 ; i  < nums.length ; i++) {

            coverage = Math.max(coverage , i + nums[i]);

            // kya abhi JUMP karne ka TIME aa gaya hai... 
            if(i == lastJumpingIndex) {

                // to JUMP se pehle lastJumpingIndex decide kar de... 
                lastJumpingIndex = coverage;

                // and because we are jumping now so .... 
                totalJumps++;

                // kahi hum destination me aa to nai gaye ?... 
                if(lastJumpingIndex == destination)
                    return totalJumps;

            }

        }

        return totalJumps;

    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        int ans = jumpGame(nums);
        System.out.println(ans);

    }
}
