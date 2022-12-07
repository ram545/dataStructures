class MaxNumOfJumps{

	static int[] jumps;


	static int maxJumpsIter(int[] arr){

		int[] minJumps = new int[arr.length];
		int iter = arr.length-1, iter1, temp;

		minJumps[iter] = 0;
		iter--;
		while(iter >= 0){

			if(arr[iter] == 0)
				minJumps[iter] = Integer.MAX_VALUE;
			else if(iter + arr[iter] > arr.length)
				minJumps[iter] = 1;
			else{
				minJumps[iter] = Integer.MAX_VALUE;
				iter1 = 1;
				while( iter1 <= arr[iter] && (iter+iter1) < arr.length){
					if(minJumps[iter] > minJumps[iter+iter1])
						minJumps[iter] = minJumps[iter+iter1];
					iter1++;
				}

				if(minJumps[iter] != Integer.MAX_VALUE)
					minJumps[iter]++;
			}
			iter--;
		}

		return minJumps[0];
	}


	static int maxJumpsRec(int[] arr, int index, int length){
		if(jumps[index] != -1)
			return jumps[index];

		if(arr[index] == 0)
			return Integer.MAX_VALUE;

		if(index+ arr[index] >= length)
			return 1;

		int iter = 1, min = Integer.MAX_VALUE, temp=0;
		while( iter <= arr[index] ){
			temp = maxJumpsRec(arr, index+iter, length);
			min = (temp > min)?min:temp;
			iter++;
		}
		if(min != Integer.MAX_VALUE)
			min++;
		jumps[index] = min;
		return min;
	}


	public static void main(String[] args){
		int[] arr = {1, 3, 5, 4, 3, 2, 1, 5, 6, 8, 9};
		int iter = 0;
		jumps = new int[arr.length];
		while(iter < arr.length)
			jumps[iter++] = -1;
		System.out.println(maxJumpsRec(arr, 0, arr.length-1));
		System.out.println(maxJumpsIter(arr));
	}
}