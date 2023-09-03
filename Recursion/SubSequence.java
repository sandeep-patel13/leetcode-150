import java.util.*;
public class SubSequence {

    public static void subsequences(String input , String output , int index , ArrayList<String> ans) {


        if(index >= input.length()){
            ans.add(output);
            return;
        }

        subsequences(input, output, index+1, ans);

        char ch = input.charAt(index);
        output = output + ch;
        subsequences(input, output, index+1, ans);

    }

    public static void main(String[] args) {
        
        String input = "abc";

        ArrayList<String> ans = new ArrayList<>();

        int index = 0;

        String output = "";

        subsequences(input , output , index , ans);

        System.out.println(ans);

    }
}
