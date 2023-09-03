public class Factorial {

    public static int factorial(int n) {

        // BASE CASE 
        if(n == 0)
            return 1;
        
        // RECURRENCE RELATION 
        return n * factorial(n-1);

    }

    public static void main(String[] args) {
        
        int n = 5;
        System.out.println(factorial(n));

    }
}
