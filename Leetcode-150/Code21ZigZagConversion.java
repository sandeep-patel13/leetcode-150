import java.util.ArrayList;

public class Code21ZigZagConversion {

    public static String solve(String str , int numberOfRows) {
        if(numberOfRows == 1)
            return str;

        ArrayList<ArrayList<Character>> list = new ArrayList<>(numberOfRows);
        for(int i = 0 ; i < numberOfRows ; i++)
            list.add(new ArrayList<>());

        int index = 0;
        boolean flag = false;

        for(int i = 0 ; i < str.length(); i++) {
            list.get(index).add(str.charAt(i));
            if(index == 0 || index == numberOfRows-1)
                flag = !flag;
            if(flag)
                index++;
            else 
                index--;
        }

        String zigZagString = "";
        for(int i = 0 ; i < list.size() ; i++) {
            ArrayList<Character> al = list.get(index);
            for(int j = 0 ; j < al.size() ; j++) {
                zigZagString += al.get(j);
            }
        }

        return zigZagString;
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numberOfRows = 3;
        String zigZagString = solve(s , numberOfRows);

    }
}