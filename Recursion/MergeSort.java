// MERGER SORT USING RECURSION
public class MergeSort{

    public static void mergeSort(int arr[],int first,int last){
        
        /* FLOW OF MERGE SORT CODE 

        a : Firstly mergeSort will simply divide the whole arr in two halfs/parts 
        b : then it will pass the first part to first recursive call 
        c : and second part will be sent to second recurive call
        d : after compeletion of these two recursive calls , mergeSort() will simply merge those two halfs
            in sorted manner with the help of meger()
        */

        int mid;
        if(first < last){
            mid=(first+last)/2;
            mergeSort(arr,first,mid);
            mergeSort(arr,mid+1,last);
            merge(arr,first,last);
        }
    }

    public static void merge(int arr[],int first,int last) {
        //SOME VARIABLES FOR DIFFERENTIATING TWO HALFS FOR MERGING THEM
        int mid=(first+last)/2;
        int i1=0;
        int i2=first;
        int i3=mid+1;
        int temp[]=new int[10];

        // (i2 <= mid) REPERSENTES FIRST HALF , (i3 <= last) REPERESENTES SECOND HALF

        /*NOW JUST COMPARE ELEMENTS OF THOSE TWO HALFS AND SORT THEM , TILL THEY BOTH HAVE MINIMUM 
        ONE ELEMENT */

        while(i2<=mid && i3<=last) {
            if(arr[i2] < arr[i3]){
                temp[i1]=arr[i2];
                i2++;
            }
            else{
                temp[i1]=arr[i3];
                i3++;
            }
            i1++;
        }

        // NOW , COPYING SOME REMAINING ELEMENTS IN temp[]
        if(i2<=mid){
            while(i2<=mid){
                temp[i1]=arr[i2];
                i2++;
                i1++;
            }
        }
        else{
            while(i3<=last){
                temp[i1]=arr[i3];
                i3++;
                i1++;
            }
        }

        // AT THE END COPY YOUR temp[] INTO arr[]
        int i=0;
        while(i<i1) {
            arr[first+i]=temp[i];
            i++;
        }
        
    }

    public static void main(String []args) {
        int arr[]=new int[]{10 , 2 , 3 , 30 , 20 , 876 , 0};
        
        mergeSort(arr,0,arr.length-1);

        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}