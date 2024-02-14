public class Code19LongestCommonPrefix{

    public static String solve(String[] strs) {
        String str = strs[0];
        String ans = "";
        String s1 = "";

        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);

            s1 = s1 + ch;

            // check whether s1 is presented in remaining strings
            boolean flag = true;
            for(int j = 1 ; j < strs.length ; j++) {
                if(strs[j].startsWith(s1) == false) {
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                ans = s1;
            else
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"abcd", "abc" , "abcsand"};
        System.out.println("Longest Common Substring is : "+solve(arr));
    }
}