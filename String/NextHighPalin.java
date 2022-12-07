
class NextHighPalin{


	static void swap(char[] arr, int index1, int index2){
		char temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	static void reverse(char[] arr, int index1, int index2){
		int iter = 0, len = (index2-index1)/2;

		while(iter <= len){
			swap(arr, index1+iter, index2-iter);
			iter++;
		}
	}

	static String nextHighestPalindrome(char[] palindrome, int len){
		int mid = 0, iter = 0, iter1, index1 = 0, index2 = 0;
		char temp, smallest = '0', largest = '0';
		String output = "";
		mid = (len-1)/2;
		if( len%2 != 0)
			mid--;

		if( len <= 3)
			return "Not Possible";

		iter = mid-1;
		while( iter >= 0){
			if(palindrome[iter] < palindrome[iter+1]){
				smallest = palindrome[iter];
				largest = palindrome[iter+1];
				index1 = iter;
				index2 = iter+1;
				break;
			}
			iter--;
		}

		if(iter == -1)
			return "Not Possible";

		for(iter1 = iter+1; iter1 <= mid; iter1++){

			if(smallest < palindrome[iter1] && palindrome[iter1] < largest){
			 	largest = palindrome[iter1];
			 	index2 = iter1;
			}
		}

		swap(palindrome, index1, index2);
		swap(palindrome, len-index1-1, len-index2 - 1);

		reverse(palindrome, index1+1, mid);
		if(len%2 == 0)
			reverse(palindrome, mid+1, len-index1-2);
		else 
			reverse(palindrome, mid+2, len-index1-2);

		for( char c: palindrome)
			output += c;

		return output;
	}

	public static void main(String[] args){
		String s = "4697557964";
		System.out.println("Input Palidrome: " + s);
		char[] input = s.toCharArray();
		String output = nextHighestPalindrome(input, s.length());
		System.out.println("Next Largest Palindrome: " + output);
	}
}