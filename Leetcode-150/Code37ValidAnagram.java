import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code37ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] charS =  s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for(int i=0;i<charS.length;i++){
            if(charS[i]!=charT[i]){
                return false;
            }
        }
        return true;

    }

    public static boolean isAnagram2(String s , String t) {

        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),1);
            }else{
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i),value+1);
            }
        }
        for(int i = 0 ; i < t.length() ; i++){
            if( (!map.containsKey(t.charAt(i))) || (map.get(t.charAt(i))==0) )
                return false;
        }
        for(Map.Entry<Character , Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0)
                return false;     
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "car";
        String t = "cat";
        boolean ans = isAnagram(s , t);
        if(ans)
            System.out.println("T is anagram of S...");
        else 
            System.out.println("T is Not anagram of S...");
    }

}
