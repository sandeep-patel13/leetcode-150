import java.util.Stack;

public class pop {

    static void reverse(String str) {

        Stack<Character> s = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++) 
            s.push(str.charAt(i));

        str = "";
        while(!s.isEmpty())
            str = str + s.pop();

        System.out.println(str);
    }

    static String reverse1(String str) {

        // base case 
        if(str.isEmpty() || str.length() == 1)
            return str;

        // first character 
        char ch = str.charAt(0);
        
        // remaining string 
        str = str.substring(1, str.length());

        // baaki ki string ko recursion reverse kar dega 
        String retStr = reverse1(str);

        // now add first char at the end 
        return retStr + ch;

    }
    
    public static void main(String[] args) {
        
        String s = "sandeep";
        System.out.println(reverse1(s));

    }

}
