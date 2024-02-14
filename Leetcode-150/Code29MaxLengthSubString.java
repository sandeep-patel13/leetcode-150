import java.util.HashMap;
public class Code29MaxLengthSubString{

    public static int solve(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int left = 0 , right = 0 , maxLength = 0;
        while(right < s.length()) {
            if(map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right)) + 1 , left);

            map.put(s.charAt(right) , right);
            maxLength = Math.max(maxLength , right-left+1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcdabcda";
        int maxLength = solve(s);
        System.out.println(maxLength);
    }
}