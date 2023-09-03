import java.util.*;

public class Permutation {

    public static void swap(StringBuffer str , int i , int j) {

        char temp = str.charAt(i);
        str.replace(i, i+1, str.charAt(j)+"");
        str.replace(j , j+1 , temp+"");


    }


    public static void permutation(StringBuffer str , ArrayList<StringBuffer> ans , int index) {

        if(index >= str.length()) {

            System.out.println(str);
            return;

        }


        for(int i = index ; i < str.length() ; i++) {

            swap(str, index, i);
            permutation(str , ans , index+1);
            swap(str, index, i);    

        }

    }


    public static void main(String[] args) {
        
        StringBuffer sf = new StringBuffer("abc");
        ArrayList<StringBuffer> ans = new ArrayList<>();
        permutation(sf , ans , 0);
        System.out.println(ans);

    }


}