import java.util.ArrayList;

public class Code2RemoveElement {

    public static int removeElement1(int[] nums , int val) {

        int startIndex = 0;

        for(int i = 0 ; i < nums.length ; i++) {

            if(nums[i] != val)
                nums[startIndex++] = nums[i];

        }

        return startIndex;

    }

    public static int removeElement(int[] nums , int val) {

        // create an arrayList 
        ArrayList<Integer> list = new ArrayList<>();

        // iterate
        for(int i = 0 ; i < nums.length ; i++) {

            if(nums[i] != val) 
                list.add(nums[i]);

        }

        for(int i = 0 ; i < list.size() ; i++) {
            nums[i] = list.get(i);
        }

        return list.size();

    }

    public static void main(String[] args) {
        
        int[] nums = {2 , 2};
        int val = 2;
        int ans = removeElement(nums , val);
        System.out.println(ans);

    }
}
