import java.util.List;
import java.util.ArrayList;

public class FindAllDuplicates {
    public static void main(String[] args) {
        
        // array , size N , can contain ele from [1 , N] range , all ele will occure for either ONE or TWO times 
        int[] arr = new int[] {4,3,2,7,8,2,3,1};

        // countArray 
        int[] countArray = new int[arr.length + 1];

        // ansList 
        List<Integer> ansList = new ArrayList<>();


        // traverse arr 
        for(int i = 0 ; i < arr.length ; i++) {

            // get ele as index in countArray 
            int index = arr[i];

            // increase count 
            countArray[index]+=1;

        }
        
        // check whether any index has greater than ONE value 
        for(int i = 0 ; i < countArray.length ; i++) {

            if(countArray[i] > 1) {

                ansList.add(i);

            }

        }

        System.out.println(ansList);
    }
}
