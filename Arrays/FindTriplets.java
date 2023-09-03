import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class FindTriplets {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

		Set<ArrayList<Integer>> set = new HashSet<>();

		for(int i = 0 ; i < n ; i++) {

			for(int j = i+1 ; j < n ; j++) {

				for(int k = j+1 ; k < n ; k++) {

					// System.out.println("i = "+i+" j = "+j+" k = "+k);
					if((arr[i] + arr[j] + arr[k]) == K) {

						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(0, arr[i]);
						temp.add(arr[j]);
						temp.add(arr[k]);
						Collections.sort(temp);

						set.add(temp);
					}
						
				}

			}

		}
		// System.out.println(set);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Iterator<ArrayList<Integer>> it = set.iterator();
		while(it.hasNext()) {
			ans.add(it.next());
		}
		return ans;

	}


    public static void main(String[] args) {
        
            FindTriplets.findTriplets(new int[]{10 , 5 , 5 , 5 , 2}, 5, 12);


    }
}
