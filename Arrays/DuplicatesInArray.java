import java.util.HashSet;

public class DuplicatesInArray {

    public static void method1(int[] array) {

        int ans = 0;

        for(int i = 0 ; i < array.length; i++) {

            ans = ans ^ array[i];

        }

        for(int i = 1 ; i < array.length ; i++) {

            ans = ans ^ i;

        }

        System.out.println(ans);

    }

    public static int method2(int[] a) {

        HashSet<Integer> hs = new HashSet<>();

        for(Integer num : a) {
            if(hs.contains(num))
                return num;
            hs.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        
        // array can contains elements from [1 to N-1] , and all for atleast one time , output - 3 
        int[] array = new int[] {1 , 2 , 5 , 4 , 3 , 6 , 3};
        
        int x = method2(array);

        System.out.println(x);

    }
}
