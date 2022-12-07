

class ProdArray{


	static void productArray(int[] arr){
		int[] temp = new int[arr.length];
		int[] temp1 = new int[arr.length];
		int iter = 0;
		while( iter < arr.length){
			temp[iter] = 1;
			temp1[iter] = 1;
			iter++;
		}
		iter = 1;
		while(iter < arr.length){
			temp[iter] = temp[iter-1]*arr[iter-1];
			iter++;
		}
		iter = arr.length-2;
		while(iter >= 0){
			temp1[iter] = temp1[iter+1]*arr[iter+1];
			iter--; 
		}

		iter = 0;
		while(iter < arr.length){
			arr[iter] = temp[iter] * temp1[iter];
			System.out.println(arr[iter]);
			iter++;
		}
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};

		productArray(arr);
	}
}