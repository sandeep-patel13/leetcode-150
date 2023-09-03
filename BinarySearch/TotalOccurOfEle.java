
public class TotalOccurOfEle {
    public static void main(String[] args) {
        
        int[] arr = new int[] {1, 2, 3, 3, 3, 3, 3, 3, 4, 4, };

        // sabse pehle to binary search lagakar element find karo 
        int start= 0 , end = arr.length - 1 , mid = 0 , key = 3;

        // mid nakaal lo 
        mid = start + (end - start) / 2;

        // occurrence 
        int occurrence = 0;

        // loop chalo jab tak ki, s <= e
        while(start <= end) {

            // agar ele mil gaya 
            // matlab ele 1 baar to definetly aaya hai 
            occurrence+=1;

            // and ab left most ele find karo 
            int i = mid - 1;
            
            // loop chalao , jab tak i >= 0 && arr[i] == key 
            while(i >= 0 && arr[i] == key) {
                
                // means ele again present hai 
                occurrence+=1;
                i--;
                
            }
            
            // and ab right most ele find karo 
            int j = mid + 1;

            // loop chalao , jab tak j < n && arr[j] == key 
            while(j < arr.length && arr[j] == key) {

                // means ele again present hai 
                occurrence+=1;
                j++;

            }

            System.out.println("occurrence : "+occurrence);
            return;
        }

        if(key > arr[mid]) {

            // right part 
            start = mid + 1;

        }
        
        else {
            
            // left part 
            end = mid - 1;

        }

        System.out.println("occurrence : "+occurrence);

    }
}
