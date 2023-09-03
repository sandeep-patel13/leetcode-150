public class ReverseString {

    static String reverse(String str) {

        if(str.length() == 0)
            return "";

        char ch = str.charAt(0);
        String s = reverse(str.substring(1));
        return s + ch+" ";
            
    }

    public static void main(String[] args) {
        
        // String str = "abcdefghijklmnopqrstuvwxyz";
        // String str = "";
        String str = "a";

        String reversedString = reverse(str);

        System.out.println(reversedString);

    }
}
