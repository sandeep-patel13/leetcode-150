public class ReachToNthStair {

    static int countWays(int n) {

        if(n == 0)
            return 1;
        
        if(n < 0)
            return 0;

        return countWays(n-1) + countWays(n-2);


    }


    public static void main(String[] args) {
        

        int n = 3;

        int ans = countWays(n);

        System.out.println(ans);


    }
}
