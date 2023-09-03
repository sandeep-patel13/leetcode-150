public class PowerWay2 {

    public static int powerWay2(int a , int b) {

        if(b == 0)
            return 1;
        if(b == 1)
            return a;

       return powerWay2(a , b/2) * powerWay2(a, b/2);

    }

    public static void main(String[] args) {
        
        int a = 5;
        int b = 6;

        if(b % 2 == 0){

            int answer = powerWay2(a , b);
            System.out.println(answer);

        }
        else {

            int answer = powerWay2(a , b);
            System.out.println(answer * a);

        }


    }
}
