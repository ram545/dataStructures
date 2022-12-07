import java.util.HashMap;

class MajorFreqElem{


	static void freqMoreThanHalfNSpace(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : arr){
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i, 1);
		}

		map.forEach( (K,V) -> { if(V > (arr.length/2))
									System.out.println("Found the Element: " + K + " occurs " + V); });
	}


	// moore's voting algo O(1) space
	static void freqMoreThanHalf(int[] arr){
		int maxIndex = 0, count = 1, iter = 1;

		while( iter < arr.length){
			if(arr[maxIndex] != arr[iter]){
				count --;
				if( count == 0){
					maxIndex = iter;
					count = 1;
				}
			}
			else{
				count++;
			}
			iter++;
		}

		iter = 0;
		count = 0;
		while( iter < arr.length){
			if(arr[iter] == arr[maxIndex])
				count++;
			iter++;
		}

		if(count > arr.length/2)
			System.out.println("Found the Element: " + arr[maxIndex] + " occurs " + count);
		else 
			System.out.println("No Such Element Present");
	}


	public static void main(String[] args){
		int[] arr = new int[]{ 1, 1, 2, 4, 3, 5, 1 };

		freqMoreThanHalfNSpace(arr);

		freqMoreThanHalf(arr);

	}
}