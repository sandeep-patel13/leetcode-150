// LOGIC 
// digit se khelte aana chahiye 

public class ReverseTheNumber {

    public static void main(String[] args) {
        
        int n = 1000023;

        // Integer ki range se larger values ko store karne ke liye,
        // because agar kisi number ka reverse , out of the Integer range chala gaya hai,
        // to hume ase number ke liye unka reverse 0 return karna,
        // to Integer ki range se bade value ko store karne ke liye ans ko long datatype se banaya gaya h
        long ans = 0;
        int digit = 0;

        // jab tak x != 0
        while(n != 0) {

            // get digit 
            digit = n % 10;

            // create answer in same flow ans = (10 * ans) + digit 
            ans = (10 * ans) + digit;

            // check
            if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
                System.out.println("0");

            // for accessing each digit 
            n = n / 10;

        }

        System.out.println(ans);
    }
    
}
