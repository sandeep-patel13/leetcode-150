public class PositiveDecimalToBinaryApp1 {
    public static void main(String[] args) {
        
        int n = 15;

        int digit , quo;
        
        int ans = 0;

        for(int i = 0 ; n != 0 ; i++) {


            quo = n / 2;
            digit = n % 2;

            // making digit in REVERSE FLOW ans = (10^i * digit) + ans 
            ans = (int)(Math.pow(10, i) * digit) + ans;

            n = quo;

        }

        System.out.println(ans);

    }


}
