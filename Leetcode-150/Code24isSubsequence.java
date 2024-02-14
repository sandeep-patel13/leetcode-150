public class Code24isSubsequence {

    public static boolean isSubsequence(String s , String t) {
        
        int i = 0 , j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else 
                j++;
        }

        return (i == s.length()) ? true : false;

    }

    public static void main(String[] args) {
        
        String subsequence = "abc";
        String string = "ahdbgfc";
        boolean ans = isSubsequence(subsequence , string);

    }    
}
