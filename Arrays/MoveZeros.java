import java.util.Arrays;
public class MoveZeros {

    public static void moveZeros(int[] nums, int n) {


        for(int i = 0 ; i < nums.length-1 ; i++) {

            if(nums[i] == 0) {

                // number dhundkar laao
                for(int j = i+1 ; j < nums.length ; j++) {

                    if(nums[j] != 0) {

                        // swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;

                    }

                }

            }

        }


    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {2 , 4 , 0 , 2 ,0 , 0 , 10};

        moveZeros(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }
}
