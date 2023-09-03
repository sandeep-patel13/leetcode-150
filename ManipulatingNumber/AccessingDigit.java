public class AccessingDigit {
    public static void main(String[] args) {
        
        int n = 5356;

        // print digit 
        while(n != 0) {

            int rem = n % 10;
            System.out.print(rem);
            n = n / 10;

        }

    }
}
