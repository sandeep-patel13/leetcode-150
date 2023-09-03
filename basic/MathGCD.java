public class MathGCD {
    public static void main(String[] args) {
        
        int a = 24, b = 72;

        // jab tak dono hi 0 ke barabar na ho jaaye,
        // tab tak loop chalao 
        while(a != 0 && b == 0) {

            if(a > b) {

                int rem = a % b;
                a = rem;

            }
            else {

                int rem = b % a;
                b = rem;

            }

        }

        if(a == 0)
            System.out.println(b);
        else 
            System.out.println(a);

    }
}
