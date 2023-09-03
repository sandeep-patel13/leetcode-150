
public class SquareRootUsingBinarySearch {

    public static int squareRoot(int n) {

        long start = 0 , end = n , mid = 0 , squareRoot = -1;

        mid = start + (end - start) / 2;

        // loop chalao,
        // jab tab start <= end 
        while(start <= end) {

            long square = mid * mid;

            if(square == n) {
                squareRoot = mid;
                break;
            }

            // means square abhi bhi small hai n se,
            // so we need to go to right part,
            // kyuki wahi badi vaklues hai 
            if (square < n) {

                // ye ek possible answer(floor value) hai 
                squareRoot = mid;
                start = mid + 1;

            }
            else {

                end = mid - 1;

            }

            mid = start + (end - start) / 2;

        }
        return (int)squareRoot;
    }

    public static double squareRootWithPrecision(double ans, int precesion, double n) {

        double factor = 1;
        
        for(double i = 0 ; i < precesion ; i++) {

            factor = factor / 10;

            for(double j = ans ; j * j < n ; j = j + factor) {

                ans = j;

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        
        int n = 100000;
        int squareRoot = squareRoot(n);
        System.out.println(squareRoot);
        double squareRootWithPrecesion = squareRootWithPrecision(squareRoot, 3, n);
        System.out.print(String.format("%.3f",squareRootWithPrecesion));

    }
}
