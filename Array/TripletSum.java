import java.util.HashMap;
import java.util.Arrays;

public class TripletSum {

	static void findTriplets(int[] arr, int sum){
		int i = 0, j = 0, len = arr.length, count=0, k=0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int r: arr)
			map.put(r, map.getOrDefault(r,0)+1);

		while(i < len-2){
			j = i+1;
			while(j < len-1){
				k = sum-arr[i]-arr[j];
				count = 1;
				if(k == arr[i])
					count++;
				if(k == arr[j])
					count++;
				if(map.getOrDefault(k,-1) >= count){
					System.out.println(arr[i]+ " " + arr[j] + " " + k);
					return;
				}
				j++;
			}
			i++;
		}
		System.out.println("No Such Matches Found");
	}

    public static void main(String... args){
    	int arr[] = {1, 2, 3, 4, 5};
    	int sum = 20;
    	Arrays.sort(arr);
    	findTriplets(arr, sum);
    }
}
