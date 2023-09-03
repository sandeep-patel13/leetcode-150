import java.util.*;
public class SubsetsNotWorking{

    public static void subsets(int[] arr , ArrayList<Integer> output , int index ,  ArrayList<ArrayList<Integer>> ans) {

        if(index >= arr.length) {

            ans.add(output);
            return;

        }


        // exclude 
        subsets(arr, output, index+1, ans);

        // include 
        int ele = arr[index];
        output.add(ele);
        subsets(arr, output, index+1, ans);       

    }


    public static void main(String[] args) {

        int[] arr = new int[] {1 , 2 , 3};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<>();

        int index = 0;

        subsets(arr , output , index , ans);

        // System.out.println(ans);

    }

}