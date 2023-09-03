public class PrintCount {

    static void printConting(int n) {

        // BASE CASE 
        if(n == 0)
            return;

        // RECURRENCE RELATION 
        System.out.print(n+" ");
        printConting(n-1);

    }

    public static void main(String[] args) {
        
        int n = 10;

        printConting(n);

    }
}
