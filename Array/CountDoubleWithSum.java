import java.util.Arrays;
import java.util.HashMap;


public class CountDoubleWithSum {

	// using sorting and two pointers approach
	public static void isPairExists(int[] arr, int sum){
		int first = 0, last = arr.length-1;
		boolean isPresent = false;
		Arrays.sort(arr);
		while(first < last){

			if(arr[first] + arr[last] == sum){
				isPresent = true;
				break;
			}
			else if(arr[first] + arr[last] > sum)
				last--;
			else
				first++;
		}

		if(isPresent)
			System.out.println("Found Pair at: " + arr[first] + " " + arr[last]);
		else
			System.out.println("Not Such Pair Exists");
	}

	public static int binarySearch(int[] arr, int low, int high, int target){
		int mid;
		while(low < high){
			mid = (low+high)/2;
			if(arr[mid] == target){
				return mid;
			}
			else if(arr[mid] < target)
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	}

	//using sorting and binary search
	public static void isPairExistsBS(int[] arr, int sum){
		int iter = 0, next=0;
		boolean isPresent = false;
		Arrays.sort(arr);
		while(iter < arr.length){
			if(arr[iter] > sum)
				break;
			next = binarySearch(arr, iter, arr.length-1, sum-arr[iter]);
			if(next >= 0 && next != iter){
				isPresent = true;
				break;
			}
			iter++;
		}


		if(isPresent)
			System.out.println("Found Pair at: " + arr[iter] + " " + arr[next]);
		else
			System.out.println("Not Such Pair Exists");
	}	

	//using hashmap
	public static void isPresentHash(int[] arr, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean isPresent = false;
		for(int x: arr){
			if(map.containsKey(x))
				map.put(x, map.get(x)+1);
			else 
				map.put(x, 1);
		}
		for(int i : arr){
			if(i < sum){
				if(map.containsKey(sum-i)){
					if(sum == 2*i){
						if(map.get(i) >= 2){
							isPresent = true;
							break;
						}
					}
					else{
						isPresent = true;
						break;
					}
				}
			}
		}

		if(isPresent)
			System.out.println("Found Pair");
		else
			System.out.println("Not Such Pair Exists");
	}



    public static void main(String... args){
        int[] arr = { 1, 4, 45, 6, 10, -8 };
        int sum = 16;
        isPairExists(arr,sum);
        isPairExistsBS(arr,sum);
        isPresentHash(arr, sum);
    }
}
