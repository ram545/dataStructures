

class AlternatePosNeg{


	static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


	static int splitPosNeg(int[] arr){
		int start = 0, iter = 0, len = arr.length, key = 0;
		while(iter < len){
			if(arr[iter] < key){
				swap(arr, iter, start);
				start++;
			}
			iter++;
		}
		return start;
	}


	static void alternatePosNeg(int[] arr){
		int div, iter = 0, len = arr.length;
		div = splitPosNeg(arr);

		if( div == 0 || div == len-1)
			return;

		while(iter < len && div < len){
			swap(arr, iter, div);
			iter += 2;
			div += 1;
		}
	}

	public static void main(String[] args){
		int[] arr = { 2, 3, -4, -1, 6, -9, 5, 8 };
		alternatePosNeg(arr);

		for(int i : arr)
			System.out.println(i);
	}
}