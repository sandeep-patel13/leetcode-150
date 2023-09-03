import java.util.ArrayList;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        
        int[] arr1 = new int[] {3 , 5 , 0};
        int[] arr2 = new int[] {6 , 5 , 0};
        int ans = 0;

        // make number from arr1 
        for(int i = 0 ; i < arr1.length ; i++) {

            // SAME FLOW 
            ans = (10 * ans) + arr1[i];

        }
        
        int number1 = ans;
        
        ans = 0;
        
        // make number from arr1 
        for(int i = 0 ; i < arr2.length ; i++) {

            // SAME FLOW 
            ans = (10 * ans) + arr2[i];

        }
        
        int number2 = ans;

        // now add these both 
        int answer = number1 + number2;

        // store number in form of array    
        ArrayList<Integer> answerList = new ArrayList<>();

        while(answer != 0) {

            answerList.add(0, answer % 10);
            answer/=10;

        }
        
        System.out.println(answerList);

    }
}
