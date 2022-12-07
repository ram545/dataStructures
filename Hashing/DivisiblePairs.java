import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class DivisiblePairs {

	static boolean isDivisible(int[] arr, int k){
		if( k%2 != 0)
			return false;
		int temp;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i: arr){
			temp = (((i)%k+k)%k);
			map.put(temp, map.getOrDefault(temp,0)+1);
		}

		map.forEach( (K,V) -> {System.out.println(K + " " + V);});
		temp = 0;
		for(;temp < k;temp++){
			if(map.containsKey(temp)){
				if(temp == 0 && map.get(temp)%2 != 0)
					return false;

				if(temp == k/2 && map.get(temp)%2 != 0)
					return false; 

				if(map.containsKey(k-temp)){
					if(map.get(temp) != map.get(k-temp))
						return false;
				}
				else
					return false;
			}
		}
		return true;
	}

    public static void main(String... args){
	    int arr[] = {9, 7, 6, 3};
	    int k = 10;
	    System.out.println(isDivisible(arr, k));
    }
}
