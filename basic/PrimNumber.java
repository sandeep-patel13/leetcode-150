//CRUCKS
// for checking whether the number is prime or not,
// just check one thing that , is there any factor of that number from [2 to n-1],
// if there is any factor then that is not prime,
// otherwise that is prime 

public class PrimNumber {
    public static void main(String[] args) {
        
        int n = 2;

        boolean flag = true;

        if(n == 1)
            flag = false;

        for(int i = 2 ; i < n-1 ; i++) {

            if((n % i) == 0) 
            {
                
                flag = false;
                break;

            }

        }

        if(flag == true) 
            System.out.println(n+" is prime number");
        else 
            System.out.println(n+" is not prime number");

    }
}
