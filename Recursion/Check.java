import java.util.Arrays;
public class Check {

    // static void swap(StringBuffer str , int i , int j) {

    //     char temp = str.charAt(i);
    //     str.replace(i, i+1, str.charAt(j)+"");
    //     str.replace(j , j+1 , temp+"");

    // }

    static void make2d() {

        boolean[][] x = new boolean[3][3];
        for(int i = 0 ; i < x.length ; i++) {
            System.out.println(Arrays.toString(x[i]));
        }

    }

    public static void main(String[] args) {
        
        // StringBuffer str = new StringBuffer("abc");
        // swap(str, 0 , 2);
        // System.out.println(str);

        make2d();

        String s = "ABC";
        System.out.println(s.substring(0, 2));

    }

}