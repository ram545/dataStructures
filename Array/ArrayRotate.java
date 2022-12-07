

class ArrayRotate{


	static int[] rotateArrayNSpace(int[] arr, int K){
		int[] output = new int[arr.length];
		int iter = 0, len = arr.length, iter1 = 0;

		while( iter < (len-K)){
			output[iter+K] = arr[iter];
			iter++;
		}
		iter1 = 0;
		while(iter < len && iter1 < K){
			output[iter1] = arr[iter];
			iter++;
			iter1++;
		}
		return output;
	}

	


	public static void main(String[] args){
		int[] arr = new int[]{4,5,6,2,5,8,2,1,4,5};
		int K = 3;
		arr = rotateArrayNSpace(arr, K);
		for( int a : arr)
			System.out.println(a);
	}
}