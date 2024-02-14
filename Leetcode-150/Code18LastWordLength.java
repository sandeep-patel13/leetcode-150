public class Code18LastWordLength {

    public static int getLength(String s) {

        int i = s.length()-1;
        while(s.charAt(i) == ' ')
            i--;
        
        int length = 0;
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
            length++;
        }

        return length;
    }

    public static int getLength1(String s) {
        String[] substrings = s.split(" ");
        return substrings[substrings.length-1].length();
    }

    public static void main(String[] args) {
        
        String s = "sandeep patel    ";
        System.out.println("length of last word is : "+getLength(s));

    }
}
