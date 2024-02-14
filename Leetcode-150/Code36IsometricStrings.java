import java.util.HashMap;

public class Code36IsometricStrings {
    public static boolean isIsomorphic(String s , String t) {
        HashMap<Character , Character> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(key, t.charAt(i));
            }
            else {
                if(map.get(key) !=  t.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        String s = "egg";
        String t = "abb";

        boolean  result = isIsomorphic(s,t);
        System.out.println("The strings are Isomorphic: "+result);

    }
}
