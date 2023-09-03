public class Power{


    static int power(int m, int n) {

        if(n == 0)
            return 1;


        return m * power(m, n-1);


    }
        
    public static void main(String[] args) {
        
        int m = 2;
        int n = 0;

        System.out.println(power(m, n));


    }

}