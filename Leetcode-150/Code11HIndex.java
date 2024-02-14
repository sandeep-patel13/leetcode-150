public class Code11HIndex {

    public static int findMaximumValidatingValue(int[] validations) {

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < validations.length ; i++) 
            max = Math.max(max, validations[i]);

        return max;

    }

    public static int solve1(int[] validations) {

        int low = 0 , high = validations.length-1 , mid = 0 , n = validations.length;

        while(low <= high) {

            mid = low + (high-low) / 2;

            if(validations[mid] == (n-low))
                return n-low;

            else if(validations[mid] > (n-low))
                high = mid-1;

            else 
                low = mid + 1;

        }

        return n - low;

    }

    public static int solve(int[] validations) {

        int maxValidatingVal = findMaximumValidatingValue(validations);

        int maxCount = 0;

        for(int i = 1 ; i < maxValidatingVal ; i++) {

            int count = 0;

            for(int j = 0 ; j < validations.length ; j++) {

                if(validations[j] >= i)
                    count++;

            }

            if(count >= i)
                maxCount = Math.max(maxCount, i);

        }

        return maxCount;

    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        int ans = solve(nums);
        System.out.println(ans);

    }
}
