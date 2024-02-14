import java.util.HashMap;
import java.util.HashSet;

public class Code39ContainsDuplicate2 {
    public static boolean containsDuplicate(int[] arr, int k) {
        for(int i = 0 ; i < arr.length-1 ; i++) {
            for(int j = i+1 ; j < arr.length ; j++) {
                if( arr[i] == arr[j] && (Math.abs(j-i) <= k) ){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums , int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else {
                if( (Math.abs(map.get(nums[i]) - i)) <= k )
                    return true;
                else 
                    map.put(nums[i], i);
            }
        }
        return  false;
    }
    public static boolean containsDuplicate3(int[] nums , int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(i > k)
                set.remove(nums[i-k-1]);
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3};
        boolean ans = containsDuplicate2(arr , 1);
        System.out.println(ans);
    }
}
