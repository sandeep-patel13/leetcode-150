
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class PairSum {

    public static void main(String[] args) {
        

        int[] arr = new int[] {2 , -3 , 3 , 3 , -2};
        int sum = 0;

        ArrayList<Integer[]> ans = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++) {

            for(int j = i+1 ; j < arr.length ; j++) {

                if(arr[i] + arr[j] == 0) {

                    Integer[] temp = new Integer[2];
                    temp[0] = Math.min(arr[i], arr[j]);
                    temp[1] = Math.max(arr[i], arr[j]);
                    ans.add(temp);

                }

            }

        }

        Collections.sort(ans, new Comparator<Integer[]>(){

            @Override
            public int compare(Integer[] a1, Integer[] a2) {

                if(a1[0] == a2[0]) {
                    return a1[1] - a2[1];
                }

                return a1[1]-a2[1];

            }


        });

        for(Integer[] arr1 : ans) {
            System.out.println(Arrays.toString(arr1));
        }

    }
}
