import java.util.Arrays;
import java.util.List;

public class WaveArray {

	static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// using Sorting
	static void constructWaveArray(int[] arr){
		Arrays.sort(arr);
		int iter = 0, len = arr.length;
		while( iter < len-1){
			swap(arr, iter, iter+1);
			iter += 2;
		}

		for(int i: arr)
			System.out.print(i + " ");
		System.out.println("");
	}

	// using O(N) time without swap
	static void consWaveArray(int[] arr){
		int iter = 0, len = arr.length;

		while(iter < len){

			if((iter-1) > 0 && arr[iter] < arr[iter-1])
				swap(arr, iter, iter-1);

			if((iter+1) < len && arr[iter] < arr[iter+1])
				swap(arr, iter, iter+1);

			iter += 2;
		}

		for(int i: arr)
			System.out.print(i + " ");
		System.out.println("");
	}

    public static void main(String... args){
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        constructWaveArray(arr);
        int arr1[] = {10, 90, 49, 2, 1, 5, 23};
        consWaveArray(arr1);
    }
}
