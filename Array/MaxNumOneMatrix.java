class MaxNumOneMatrix{


	static int binarySearch(int[] arr, int low, int high){
		if(low > high)
			return -1;
		int mid = (low+high)/2;

		if( arr[mid] == 1 && (mid == 0 || arr[mid-1] == 0))
			return mid;
		else if( arr[mid] == 0)
			return binarySearch(arr, mid+1, high);
		else 
			return binarySearch(arr, low, mid-1);
	}

	static int maxOneRow1(int[][] mat){
		int maxIndex = 0, iter = 0, temp, maxNum = 0;

		while( iter < mat.length){
			temp = binarySearch(mat[iter], 0 , mat[0].length-1);
			if(temp == -1){
				iter++;
				continue;
			}
			if( maxNum < (mat[0].length-temp-1)){
				maxNum = mat[0].length-temp-1;
				maxIndex = iter;
			}
			iter++;
		}	
		return maxIndex;
	}


	// O(M+N)
	static int maxOneRow(int[][] mat){
		int iter = 0, start = 0, rowLen = mat.length, colLen = mat[0].length, maxRow = 0, iter1;

		while(iter < mat[0].length && mat[0][iter] != 1){
			iter++;
		}
		maxRow = 0;
		if(iter == mat[0].length)
			start = iter-1;
		else 
			start = iter;

		iter = 1;
		while( iter < rowLen){
			iter1 = start;
			if( mat[iter][iter1] == 1){
				while(iter1 >= 0 && mat[iter][iter1] == 1){
					iter1--;
				}
				if(iter1 == -1)
					start = 0;
				else 
					start = iter1+1;
				maxRow = iter;
			}
			iter++;
		}

		return maxRow;
	}


	public static void main(String[] args){
		int[][] mat  = {{0,0,0,0},
						{0,1,1,1},
						{0,1,1,1},
						{0,0,1,1},
						{1,1,1,1}};
		System.out.println("Row is " + maxOneRow(mat));
		System.out.println("Row is " + maxOneRow1(mat));
	}
}