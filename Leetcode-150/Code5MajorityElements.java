import java.util.*;

public class Code5MajorityElements {


    public static int getMajorityElement3(int[] nums) {

        int mi = 0 , count = 1;

        for(int i = 1 ; i < nums.length ; i++) {

            if(nums[mi] == nums[i])
                count++;

            else 
                count--;

            if(count == 0) {

                mi = i;
                count = 1;

            }

        }

        return nums[mi];
    
    }
    
    public static int getMajorityElement2(int[] nums) {

        int maxCount = -1 , index = -1;

        for(int i = 0 ; i < nums.length ; i++) {

            int count = 1;

            for(int j = i+1 ; j < nums.length ; j++) {

                if(nums[j] == nums[i])
                    count++;

            }

            if(maxCount < count) {
                maxCount = count; index = i; 
            }

        }

        return nums[index];

    }

    public static int getMajorityElement1(int[] nums) {

        Arrays.sort(nums);

        int maxCount = -1 , ele = -1 , count = 0;

        for(int i = 0 ; i < nums.length; i++) {

            if(i == 0)
                count = 1;

            else {

                if(nums[i] == nums[i-1])
                    count++;

                else {

                    if(maxCount < count) {

                        maxCount = count;
                        ele = nums[i-1];

                    }

                    count = 1;

                }

            }
        }

            if(maxCount < count) {

                maxCount = count;
                ele = nums[nums.length-1];

            }

            return ele;

    }

    public static int getMajorityElement(int[] nums) {

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i : nums) {

            if(map.containsKey(i) == false)
                map.put(i , 1);
            else 
                map.put(i , map.get(i) + 1);

        }

        int limit = nums.length / 2;

        for(Map.Entry<Integer , Integer> entry : map.entrySet()) {

            int ele = entry.getKey();
            int occ = entry.getValue();

            if(occ > limit)
                return ele;

        }

        return -1;

    }

    public static void main(String[] args) {
        
        int[] nums = {2 , 2 , 3 , 2 , 0 , 0};
        int ans = getMajorityElement(nums);
        System.out.println(ans + " and "+Arrays.toString(nums));

    }

}
