import java.util.LinkedHashMap;


class FreqEachElement{


	static void freqOfEachElement(int[] arr){
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		int iter = 0, len = arr.length;

		while(iter < len){
			if(map.containsKey(arr[iter]))
				map.put(arr[iter], map.get(arr[iter])+1);
			else
				map.put(arr[iter],1);
			iter++;
		}

		map.forEach( (K,V) -> { System.out.println(K + " Element Occured " + V + " times"); });	}

	public static void main(String[] args){
		int[] arr =  { 10, 20, 30, 30, 30, 40, 50, 50, 50, 50, 70 };

		freqOfEachElement(arr);

	}
}