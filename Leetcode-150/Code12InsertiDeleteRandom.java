import java.util.HashSet;
import java.util.Random;


class RandomaizedClass{

    HashSet<Integer> set;

    public RandomaizedClass() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {

        if(set.contains(val))
            return false;

        set.add(val);
        return true;

    }

    public boolean remove(int val) {

        if(!set.contains(val))
            return false;

        set.remove(val);
        return true;

    }

    public int getRandomNumber() {

        int size = set.size();
        Integer[] arr = new Integer[size];
        set.toArray(arr);
        Random r = new Random();
        return arr[r.nextInt(size)];

    }

}

public class Code12InsertiDeleteRandom{



    public static void main(String[] args) {
        
        

    }

}