public class NegativeDecimalToBinaryUC {

    public static int toBinary(int n) {

        

    }

    public static void main(String[] args) {


        int n = -6;
        n = Math.abs(n);

        // 1's Complement 
        n = ~n;
        System.out.println(n);

        // 2's Complement 
        n = n + 1;
        System.out.println(n);

        // find binary reperesentation 
        System.out.println(toBinary(n));

    }

}
