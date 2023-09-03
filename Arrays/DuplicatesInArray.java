public class DuplicatesInArray {
    public static void main(String[] args) {
        

        // array can contains elements from [1 to N-1] , and all for atleast one time , output - 3 
        int[] array = new int[] {1 , 2 , 5 , 4 , 3 , 6 , 3};

        int ans = 0;

        for(int i = 0 ; i < array.length; i++) {

            ans = ans ^ array[i];

        }

        for(int i = 1 ; i < array.length ; i++) {

            ans = ans ^ i;

        }

        System.out.println(ans);

    }
}
