
public class KthElementSortedArrays {

	public static int mergeSortedArrays(int[] a, int[] b, int K){
		int iter = 0, iter1 = 0, iter3 = 0, ans;

		if( K < 0 || K > (a.length+b.length)){
			System.out.println("Out of Range");
			return -1;
		}
		while( iter < a.length && iter1 < b.length){
			if( a[iter] < b[iter1]){
				ans = a[iter];
				iter++;
			}
			else{
				ans = b[iter1];
				iter1++;
			}
			if(iter3 == K-1){
				return ans;
			}
			iter3++;
		}
		return -1;
	}

    public static void main(String... args){
    	int[] array = {100, 112, 256, 349, 770};
    	int[] array1 = {72,86,113,119,265,445,892};
    	int K = 7;
    	System.out.println(mergeSortedArrays(array, array1, K));
    }
}