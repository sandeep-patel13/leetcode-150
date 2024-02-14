import java.util.Arrays;
public class RotateArray{

    public static void bruteForce(int[] arr , int n , int[] ans , int k) {

        int j = 0;

        for(int i = n-k ; i < n ; i++) {

            ans[j++] = arr[i];

        }   
        
        for(int i = 0 ; i < k ; i++) {

            ans[j++] = arr[i];

        }

    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {10 , 20 , 30 , 40, 50, 60};
        int k = 3;
        int[] answer = new int[arr.length];

        bruteForce(arr, arr.length, answer , k);


        // for(int i = 0 ; i < arr.length ; i++) {

        //     // FORMULA 
        //     answer[(i+k) % answer.length] = arr[i];

        // }

        System.out.println(Arrays.toString(answer));

    }

}