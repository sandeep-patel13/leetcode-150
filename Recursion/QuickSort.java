public class QuickSort {


    public static int partition(int[] arr , int start , int end) {


        // arr me jo vayakti sabse pehle khada h hume uske paise ke according uski sahi position par khada karna h 
        // to us vayakti ke pass kitne rupee hai humne use nikaal liya  
        int rupeeOfFirstPerson = arr[start];

        // then ase logo kitne h jinke pass arr[start] vayakti se kam paise h,
        // ye dhundhna hai humne,
        int count = 0;


        for(int i = start + 1 ; i <= end ; i++) {
            if(arr[i] <= rupeeOfFirstPerson)
                count++;
        }


        // for ex , agar ase logo ki sankhya 4 hai , to arr[start] ki position 4 hogi right,
        // agar start 0 hai to 
        int sahiPosition = start + count;

        // SWAP 
        int temp = arr[start];
        arr[start] = arr[sahiPosition];
        arr[sahiPosition] = temp;

        // ab arr[start] to apni sahi jagah par aa chuka hai but,
        // agar is vayakti ke right side me aur left side me agar kuch log bache hai,
        // to possiblity hai ki , left side me kuch ase vayakti hai jinke pass arr[start] se jada paise ho,
        // and right side me kuch ase vayakti hai jinke pass arr[start] se kam paise ho,
        // to ase logo ko to aapas me swap karna padega 

        int i = start , j = end;

        // tak tak check karo jab tak sahiPosition ke left and right me log check karne ke liye bache hai 
        while(i < sahiPosition && j > sahiPosition) {

            // left me jitne bhi log left me hai , aur unke pass rupeeOfFirstPerson se kam paise hai,
            // vo sai h , unhe kahi jaane ki zarurat nahi h abhi,
            // to ase logo par koi processing nahi hogi 
            while(arr[i] < rupeeOfFirstPerson)
                i++;

            
            // same with right side
            while(arr[j] > rupeeOfFirstPerson)
                j--;

            // agar ek asi situation mil gayi,
            // ki left me koi asa vyakti hai jiske paas rupeeOfFirstPerson se jada paise hai,
            // ya phir right me asa vayakti jiske pass rupeeOfFirstPerson se kam paise hai,
            // ye dono hi galat jagah hai dono ko swap karo 

            if(arr[i] > rupeeOfFirstPerson && arr[j] < rupeeOfFirstPerson) {

                // SWAP 
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;

            }
        }

        // last me sahiPosition ke left me sabhi log ase log honge jinke pass rupeeOfFirstPerson se kam paise hai,
        // and sahiPosition ke right me sabhi log ase log honge jinke pass rupeeOfFirstPerson se jada paise hai
        return sahiPosition;

    }

    public static void quickSort(int[] arr , int start , int end) {

        // agar start >= end,
        // means waha ya to 1 ele bas hoga ya phir hoga hi ni,
        // to ase case me kya hi sort karoge 
        if(start >= end) 
            return;


        // PARTITION 
        int pivotIndex = partition(arr , start , end);

        // leftPart 
        quickSort(arr , start , pivotIndex - 1);

        // rightPart 
        quickSort(arr, pivotIndex+1, end);     

    }

    public static void main(String[] args) {
        
        int arr[]=new int[]{10 , 2 , 3 , 30 , 20 , 876 , 0 ,2332 , 2 , 89 , 8 , -1};
        
        quickSort(arr,0,arr.length-1);

        for(int val:arr){
            System.out.print(val+" ");
        }

    }
}
