public class FindSumOfArray {

    static int findSum(int[] arr , int sum , int i) {

        if(i == arr.length)
            return 0;

        return (arr[i] + sum) + findSum(arr, sum, i+1);
    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {0 , 10 , 20 , 5};

        int ans = findSum(arr , 0 , 0);

        System.out.println(ans);

    }
}
