import java.util.Arrays;

public class PossibleTraingles {



	// using two pointer apporach in inner loop
	static void countPossibleTriangles(int[] arr){
		int i = 0, j = 0, k = 0, count = 0, len = arr.length;

		Arrays.sort(arr);

		for(i= len-1; i>= 0 ; i--){
			j = 0;
			k = i-1;
			while(j < k){
				if(arr[j] + arr[k] > arr[i]){
					count += (k-j);
					k--;
				}
				else
					j++;
			}
		}

		if(count > 0)
			System.out.println("Matches Found: " + count);
		else
			System.out.println("No Matches Found");
	}

    public static void main(String... args){
    	int arr[] = { 10, 21, 22, 100, 101, 200, 300 };
        countPossibleTriangles(arr);
    }
}
