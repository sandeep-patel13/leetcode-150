import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class Code35RansomeNote {
    
    public static boolean solve(String s , String s1) {
        HashMap<Character , Integer> charFreq = new HashMap<>();
        for (int i=0 ; i <s.length() ;i++) {
            Character ch = s.charAt(i);
            if(charFreq.containsKey(ch))
                charFreq.put(ch ,  charFreq.get(ch)+1);
            else 
                charFreq.put(ch , 1);
        }

        for(Map.Entry<Character , Integer> entry : charFreq.entrySet()){
            Character ch = entry.getKey();
            int count = 0;
            int occ = entry.getValue();
            for(int i = 0 ; i < s1.length() ; i++) {
                if(s1.charAt(i)==ch)
                    count++;
            }
            if(occ == count)
                return true;
        }
        return false;

    }
    public static void main(String[] args) {
        String s = "aaa";
        String s1 = "aab";
        boolean ans = solve(s , s1);
        System.out.println("ans is : "+ans);
    }
}
