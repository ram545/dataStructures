import java.util.HashMap;

public class PairExists {

	static void PairExists(int[] arr,int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean pairPresent = false;
		for(int i: arr){
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i,1);
		}

		for(int i: arr){
			if(i > 2)
				return;
			if(map.containsKey(sum-i)){
				pairPresent = true;
				break;
			}
		}

		if(pairPresent)
			System.out.println("Match Found");
		else 
			System.out.println("No Match Found");
	}

    public static void main(String... args){
        int[] arr = { 0, -1, 2, -3, 1 };
        PairExists(arr, -5);
    }
}
