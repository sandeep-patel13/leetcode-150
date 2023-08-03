
public class PositiveDecimalToBinaryApp2 {
    
    public static void main(String[] args) {
        
        int n = 12;
        int ans = 0;
        int bit;

        for(int i = 0 ; n != 0 ; i++) {

            // get right most bit 
            bit = n & 1;

            // form answer in reverse flow - ans = (10^i * digit) + ans
            ans = (int)((Math.pow(10, i) * bit) + ans);

            // for accessing each bit , shift all bits to right side by 1 
            n = n >> 1;

        }

        System.out.println(ans);
    }

}
