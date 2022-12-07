
class AddOneToArray{

	static int[] addOne(int[] arr){
		int carry = 1, iter = 0, len = arr.length;
		int[] output;
		iter = len-1;
		while(iter >= 0){
			if(carry == 1){
				if(arr[iter] == 9){
					arr[iter] = 0;
					carry = 1;
				}
				else{
					arr[iter] += carry;
					carry = 0;
				}
			}
			iter--;
		}
		if(carry == 1){
			len++;
		}
		output = new int[len];
		iter = 0;
		if(carry == 1)
			output[0] = 1;
		while(iter < len-1){
			output[iter+carry] = arr[iter]; 
			iter++;
		}
		return output;
	}

	public static void main(String[] args){
		int[] arr = {9,2,9};
		int[] output = addOne(arr);
		for( int i : output)
			System.out.println(i);
	}
}