import java.lang.*;
import java.io.*;
import java.util.*;

// Given an array and a max K find the max of each sliding window
// Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
// Output: 3 3 4 5 5 5 6
// Explanation: Maximum of 1, 2, 3 is 3
//                        Maximum of 2, 3, 1 is 3
//                        Maximum of 3, 1, 4 is 4
//                        Maximum of 1, 4, 5 is 5
//                        Maximum of 4, 5, 2 is 5 
//                        Maximum of 5, 2, 3 is 5
//                        Maximum of 2, 3, 6 is 6
class QSLDM{
	static Deque<Integer> que;

	QSLDM(){
		que = new ArrayDeque<Integer>();
	}

	public static int[] calMaxEachSlidingWindow(int[] arr, int K){
		int iter = 0, length = arr.length, kIter = 0, element; 
		int[] result = new int[length-K+1];

		for(int a: result)
			a = Integer.MIN_VALUE;

		while(iter < K){
			if(que.isEmpty())
				que.add(arr[iter]);
			else{
				while(que.peekLast() < arr[iter])
					que.removeLast();
				que.addLast(arr[iter]);
			}
			iter++;
			result[kIter++] = que.element();
		}

		iter = 0;

		while( iter+K < length){
			if(arr[iter] == que.element())
				que.removeFirst();

			while(que.peekLast() < arr[iter+K])
				que.removeLast();
			que.addLast(arr[iter+K]);

			iter++;
			result[kIter++] = que.element();
		}	
		return result;
	}

	public static void main(String[] args){
		QSLDM qs = new QSLDM();
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int K = 4;
		int[] result = calMaxEachSlidingWindow(arr,K);

		for(int i: result)
			System.out.println(i);
	}

} 