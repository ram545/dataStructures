import java.util.HashMap;


public class SubWithSumK {

	static int numberOfSubArrays(int[] arr, int sum){
		int currSum = 0, remainingSum = 0, result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i: arr){
			currSum += i;
			if(sum == currSum)
				result++;
			
			if(currSum > sum){
				remainingSum = currSum - sum;
				if(map.containsKey(remainingSum))
					result += map.get(remainingSum);
			}
			map.put(currSum, map.getOrDefault(currSum, 0)+1);
		}
		return result;
	}

    public static void main(String... args){
		int arr[] = {9, 4, 20, 3, 10, 5};
		int sum = -10;
		System.out.println(numberOfSubArrays(arr, sum));
    }
}
