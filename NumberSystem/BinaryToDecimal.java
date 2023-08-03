
public class BinaryToDecimal {

    public static void main(String[] args) {
        
        int bn = 10101;
        int ans = 0;
        int digit;

        for(int i = 0 ; bn != 0 ; i++) {

            // get digit 
            digit = bn % 10;

            // if it is 1 
            if(digit == 1) {

                ans = ans + (int)Math.pow(2, i);

            }

            // for accessing each bit 
            bn = bn / 10;
        }
        System.out.println(ans);
    }

}
