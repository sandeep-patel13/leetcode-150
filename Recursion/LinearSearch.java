
public class LinearSearch{

    static int linearSearch(int[] arr , int ele , int i) {
        
        if(i == arr.length)
            return -1;

        if(arr[i] == ele) 
            return i;

        return linearSearch(arr , ele , i+1);

    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {10 , 20 , 30 , 40 , 50 , 560 ,32};

        int ans = linearSearch(arr , 590 , 0);

        if(ans != -1)
            System.out.println(ans+1);
        else 
            System.out.println(ans);
            

    }
}
