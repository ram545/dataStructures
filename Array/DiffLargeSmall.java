

class DiffLargeSmall {

	static void largeSmallDiff(int[] arr) {
		int smallest = arr[0], iter = 1, diff = Integer.MIN_VALUE;
		for ( ; iter < arr.length;) {
			if ((arr[iter] - smallest) > diff)
				diff = arr[iter] - smallest;

			if ( smallest > arr[iter])
				smallest = arr[iter];
			iter++;
		}
		System.out.println(diff);
	}


	static void largeSmallDiff1(int[] arr) {
		int iter = 1, diff = 0, maxDiff = 0, curDiff = 0;
		while ( iter < arr.length) {
			diff = arr[iter] - arr[iter - 1];
			if (diff > 0)
				curDiff += diff;
			else
				curDiff = diff;
			maxDiff = (curDiff > maxDiff) ? curDiff : maxDiff;
			iter++;
		}
		System.out.println(maxDiff);
	}

	public static void main(String[] args) {
		int[] arr = {7, 9, 5, 6, 3, 2};
		largeSmallDiff(arr);
		largeSmallDiff1(arr);
	}
}