import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class KMostOccuring {

	static void printKMostOccuring(int[] arr, int K){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

		for(int i: arr){
			map.put(i, map.getOrDefault(i,1)+1);
		}

		List<Map.Entry<Integer, Integer> > list
            = new ArrayList<Map.Entry<Integer, Integer> >(
                map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare( Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
				if(a.getValue() == b.getValue())
					return b.getKey()-a.getKey();
				else 
					return b.getValue()-a.getValue();
			}
		});

		int iter = 0;
		for(Map.Entry<Integer, Integer> o:list){
			if(iter < K){
				System.out.println(o.getKey() + " " + o.getValue());
				iter++;
			}
		}
	}

    public static void main(String... args){
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int K = 4;
    	printKMostOccuring(arr,K);
    }
}
