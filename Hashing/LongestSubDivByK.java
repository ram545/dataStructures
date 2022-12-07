import java.util.HashMap;

public class LongestSubDivByK {

	static int longestSubArray(int[] arr, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSum = 0, max_len = 0, iter = 0;
		int[] mod_arr = new int[arr.length];
		for(;iter < arr.length; iter++){
			currSum += arr[iter];

			// negative sum handler
			mod_arr[iter] = ((currSum%sum)+sum)%sum;

			if(mod_arr[iter] == 0)
				max_len++;
			else if(!map.containsKey(mod_arr[iter]))
				map.put(mod_arr[iter], iter);
			else{
				if(max_len < (iter-map.get(mod_arr[iter])))
					max_len = iter - map.get(mod_arr[iter]);
			}
		}
		return max_len;
	}

    public static void main(String... args){
		int arr[] = {-2, 2, -5, 12, -11, -1, 7};
		int k = 3;
		System.out.println(longestSubArray(arr,k));
    }
}
