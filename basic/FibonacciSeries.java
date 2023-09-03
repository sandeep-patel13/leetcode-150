// LOGIC 
// any numbers in series is a sum of previous two numbers 
// n = (n - 1) + (n - 2);

public class FibonacciSeries {
    public static void main(String[] args) {
        
        int a = 0;
        int b = 1;

        // total 10 numbers of fibonacci series should be printed 
        int n = 10;

        System.out.print(a + " " +b+" ");

        // two numbers are already printed 
        for(int i = 0 ; i < 8 ; i++) {
            
            int sum = a + b;
            System.out.print(sum+" ");
            a = b;
            b = sum;

        }

    }
}
