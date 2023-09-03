import java.util.Arrays;
public class RotateArray{

    public static void main(String[] args) {
        
        int[] arr = new int[] {10 , 20 , 30 , 40, 50, 60};
        int k = 3;
        int[] answer = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++) {

            // FORMULA 
            answer[(i+k) % answer.length] = arr[i];

        }

        System.out.println(Arrays.toString(answer));

    }

}