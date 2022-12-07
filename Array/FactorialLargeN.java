import java.math.BigInteger;

class FactorialLargeN{


	static void factUsingString(int N){
		int[] result = new int[500];
		int iter = 2, carry=0, iter1 = 0, prod, resSize=1;
		result[0] = 1;

		for(iter = 2; iter <= N; iter ++){

			for(iter1 = 0; iter1 < resSize; iter1++){
				carry = result[iter1] * iter + carry;
				result[iter1] = carry%10;
				carry = carry/10;
			}

			while(carry > 0){
				result[resSize] = carry%10;
				carry = carry/10;
				resSize++;
			}

			carry = 0;
		}


		for(iter = resSize-1; iter >= 0; iter--){
			System.out.print(result[iter]);
		}	
		System.out.println("");	
	}


	static void factUsingBigInt(int N){
		BigInteger f = BigInteger.ONE;

		int iter = 1;
		while(iter <= N){
			f = f.multiply(BigInteger.valueOf(iter++));
		}

		System.out.println(f);
	}

	public static void main(String[] args){
		int N = 100;
		factUsingString(N);
		factUsingBigInt(N);
	}
}
