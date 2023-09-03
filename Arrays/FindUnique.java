public class FindUnique {
    public static void main(String[] args) {
        

        int[] arr = new int[]{10 , 20 , 10 , 20 , 1 , 5 , 1};

        int ans = 0;

        for(int i = 0 ; i < arr.length ; i++) {

            ans = ans ^ arr[i];

        }

        System.out.println(ans);

    }
}