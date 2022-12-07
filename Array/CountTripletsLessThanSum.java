import java.util.Arrays;

public class CountTripletsLessThanSum {

	// using sorting and two pointer approach in the inner loop
	public static void noOfTriplets(int[] arr, int sum){
		int i = 0, j = 0, k = 0, count = 0, len = arr.length;
		Arrays.sort(arr);

		while(i < len-2){
			j = i+1;
			k = len-1;
			while( j < k){
				if( arr[i] + arr[j] + arr[k] > sum){
					k--;
				}
				else{
					System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					count+= (k-j);
					j++;
				}
			}
			i++;
		}

		if(count> 0)
			System.out.println("Triplets Found: " + count);
		else 
			System.out.println("No Such Matches Found");
	}

    public static void main(String... args){
        int arr[] = new int[]{5, 1, 3, 4, 7};
        noOfTriplets(arr, 12);
    }
}
