public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        
        int num = 15;
        int mask = 0;
        int num1 = num;

        // edge case 
        if(num == 0){
            System.out.println(1);
            return;
        }

        while (num1 != 0) {

            mask = (mask << 1) | 1;
            num1 = num1 >> 1;

        }

        // mask is used and & for ignoring all ones
        int ans = (~num) & mask;

        System.out.println(ans);
    }
}
