import java.util.Arrays;

public class TripletsBtwAandB {


	// using sorting and two pointer approach in the inner loop
	public static int noOfTriplets(int[] arr, int sum){
		int i = 0, j = 0, k = 0, count = 0, len = arr.length;

        Arrays.sort(arr);
		while(i < len-2){
			j = i+1;
			k = len-1;
			while( j != k){
				if( arr[i] + arr[j] + arr[k] > sum){
					k--;
				}
				else{
					count+= (k-j);
					j++;
				}
			}
			i++;
		}
		return count;
	}

    public static void main(String... args){
 		int[] arr = { 2, 7, 5, 3, 8, 4, 1, 9 };
    	int a = 8, b = 16;  
        System.out.println(noOfTriplets(arr,b) - noOfTriplets(arr,a-1));
    }
}
