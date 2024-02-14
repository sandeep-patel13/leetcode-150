import java.util.HashMap;

public class Code17RomanToInteger {

    public static Integer getIntegerFromRoman(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V' , 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for(int i = 0; i < s.length()-1; i++) {

            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))
                ans += map.get(s.charAt(i));
            else 
                ans -= map.get(s.charAt(i));

        }

        ans += map.get(s.charAt(s.length()-1));
        return ans;
    
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        Integer ans = getIntegerFromRoman(s);
        System.out.println(ans);
    }
}
