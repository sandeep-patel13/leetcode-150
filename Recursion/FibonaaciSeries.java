public class FibonaaciSeries {

    static int fibo(int n) {

        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        return fibo(n-1) + fibo(n-2);

    }


    public static void main(String[] args) {
        
        // Nth FIBONAACI NUMBER 
        int n = 7;

        int ans = fibo(n);

        System.out.println(ans);

    }
}
