import java.util.*;

public class Code4RemoveDuplicateFromSorted2 {

    public static int removeDuplicate(int[] nums) {

        int startIndex = 0;

        for(int i : nums) {

            if(startIndex == 0 || startIndex == 1 || nums[startIndex-2] != i) 
                nums[startIndex++] = i;

        }

        return startIndex;

    } 

    public static void main(String[] args) {
        
        int[] nums = {2 , 2 , 3 , 2 , 0 , 0};
        int ans = removeDuplicate(nums);
        System.out.println(ans + " and "+Arrays.toString(nums));

    }
}
