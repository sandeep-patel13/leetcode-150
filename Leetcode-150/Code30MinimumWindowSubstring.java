public interface Code30MinimumWindowSubstring {
    public static boolean containsAllCharacters(String substr , String pattern) {
        int[] count = new int[256];
        for(char ch : pattern.toCharArray())
            count[ch]++;
        for(char ch : substr.toCharArray())
            count[ch]--;
        for(int i = 0 ; i < 256 ; i++) {
            if(count[i] > 0)
                return false;
        }
        return true;
    }
    public static String solve(String str , String pattern) {
        int minLength = Integer.MAX_VALUE;
        String smallestSubstring = "";
        for(int i = 0 ; i < str.length() ; i++) {
            for(int j = i ; j < str.length() ; j++) {
                String substr = str.substring(i , j+1);
                if(containsAllCharacters(substr , pattern)) {
                    if(substr.length() < minLength) {
                        minLength = substr.length();
                        smallestSubstring = substr;
                    }
                }
            }
        }
        return smallestSubstring;
    }
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pattern = "ABC";
        String ans = solve(str , pattern);
        System.out.println("Minimum length substring is : "+ans);
    }
}
