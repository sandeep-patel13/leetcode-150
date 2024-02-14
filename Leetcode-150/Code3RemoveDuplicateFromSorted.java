import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Code3RemoveDuplicateFromSorted {

    public static int removeDuplicate2(int[] nums) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int i : nums)
            set.add(i);

        Iterator<Integer> it = set.iterator();

        int index = 0;

        while(it.hasNext()) 
            nums[index++] = it.next();

        return set.size();            

    }
        
    public static int removeDuplicate1(int[] nums) {

        int startIndex = 0;

        for(int i = 0 ; i < nums.length-1 ; i++) {

            // accessing LAST OCCURRENCE
            if(nums[i] != nums[i+1])
                nums[startIndex++] = nums[i];

        }

        nums[startIndex++] = nums[nums.length-1];

        return startIndex;
    }


    public static int removeDuplicate(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < nums.length-1 ; i++) {

            if(nums[i] != nums[i+1])
                list.add(nums[i]);

        }

        list.add(nums[nums.length-1]);

        for(int i = 0 ; i < list.size() ; i++) {

            nums[i] = list.get(i);

        }

        return list.size();
    }

    public static void main(String[] args) {
        
        int[] nums = {2 , 2 , 3 , 2 , 0 , 0};
        int ans = removeDuplicate(nums);
        System.out.println(ans + " and "+Arrays.toString(nums));

    }
}
