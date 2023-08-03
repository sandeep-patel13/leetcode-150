import java.util.Arrays;

public class SwapAlternatives {
    public static void main(String[] args) {
        
        int[] a = {1 , 2 , 3 , 4 , 5 };

        for(int i = 0 ; i < a.length ; i+=2) {

            if((i+1) < a.length) {
                int x = a[i];
                a[i] = a[i+1];
                a[i+1] = x;
            }

        }

        System.out.println(Arrays.toString(a));

    }
}
