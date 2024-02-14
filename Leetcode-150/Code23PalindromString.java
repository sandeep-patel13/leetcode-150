public class Code23PalindromString {

    public static boolean isPalindrom(String str) {
        str = str.toLowerCase();
        int i = 0 , j = str.length() - 1;
        while(i <= j) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if( !(ch1 >= 'a' && ch1 <= 'z') && !(ch1 >= '0' && ch1 <= '9') )
                i++;
            else if( !(ch2 >= 'a' && ch2 <= 'z') && !(ch2 >= '0' && ch2 <= '9') )
                j--;
            else if( ch1 == ch2 ){
                i++; j--;
            }
            else 
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println("is s palindrom : "+isPalindrom(s));
    }
}
