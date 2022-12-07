import java.util.HashSet;
import java.util.Arrays;

class LongestConsSubSeq{


	static void longestConsecutiveSequenceSorting(int[] arr){
		int iter = 0, len = arr.length, start = 0, currMax = 0, totalMax = 0;
		Arrays.sort(arr);
		while( iter < len){
			if(iter != 0 && (arr[iter]-1) != arr[iter-1]){
				start = iter;
				if(totalMax < currMax)
					totalMax = currMax;
				currMax = 0;
			}
			else 
				currMax++;
			iter++;
		}
		System.out.println("Length of max consecutive numbers in an unsorted list: " + totalMax);	
	}


	static void longestConsecutiveSequence(int[] arr){
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i: arr){
			hash.add(i);
		}

		int maxLength = -1, tempMaxLen = -1, iter;
		for(int i: arr){
			tempMaxLen = 0;
			if(hash.contains(i)){
				if(hash.contains(i-1)){
					iter = i-1;
					while(hash.contains(iter)){
						hash.remove(iter);
						iter--;
						tempMaxLen++;
					}

					iter = i;
					while(hash.contains(iter)){
						hash.remove(iter);
						iter++;
						tempMaxLen++;
					}
				}
				if(maxLength < tempMaxLen)
					maxLength = tempMaxLen;
			}
		}
		System.out.println("Length of max consecutive numbers in an unsorted list: " + maxLength);
	}

	public static void main(String[] args){
		int[] arr = {1, 9, 5, 10, 4, 20, 2};
		longestConsecutiveSequence(arr);
		longestConsecutiveSequenceSorting(arr);
	}
}