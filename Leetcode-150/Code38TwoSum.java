import java.util.HashMap;

public class Code38TwoSum {

    public static int[] twoSum(int[] arr , int target) {
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = i+1 ; j < arr.length ; j++) {
                if(arr[i]+arr[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1};
    }

    public static int[] twoSum2(int[] arr , int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i ++){
            int complement = target - arr[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            else
                map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }  

    public static void main(String[] args) {
        int[] arr = new int[]{12 , 3 , 8 , 9 ,2 , 1 , 0};
        int[] ans = twoSum(arr , 11);
        for(int i : ans){
            System.out.println(i);
        }
    } 
}
