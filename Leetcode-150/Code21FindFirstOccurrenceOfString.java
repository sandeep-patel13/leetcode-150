public class Code21FindFirstOccurrenceOfString {

    public static int solve(String haystack, String needle) {

        if(haystack.length() == needle.length() && haystack.equals(needle))
            return 0;

        for(int i = 0 ; i < haystack.length()-1 ; i++) {
            String str = haystack.charAt(i)+"";

            // limit is the limit as index 
            // limit = in which index are you now , how many steps more you need to take 
            int limit = i + needle.length()-1;
            
            for(int j = i+1 ; (limit < haystack.length() && j <= limit); j++) {
                str = str + haystack.charAt(j);
            }
            if(str.equals(needle))
                return i;
        }
        
        if((haystack.charAt(haystack.length()-1)+"").equals(needle))
            return haystack.length()-1;
        
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("First Occurrence is : "+solve(haystack , needle));
    }
}
