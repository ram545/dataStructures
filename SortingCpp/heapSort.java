import java.util.*;
import java.lang.*;
import java.io.*;


class heapSort{

	static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static void heapifyMax(int[] arr, int N, int length){
		int largest = N, left = 0, right = 0;
		left = 2*N+1;
		right = 2*N+2;

		if(left < length && arr[left] > arr[largest])
			largest = left;

		if(right < length && arr[right] > arr[largest])
			largest = right;

		if( largest != N){
			swap(arr, N, largest);
			heapifyMax(arr,largest,length);
		}
	}

	static void heapSort(int[] arr){
		int length = arr.length, iter = 0;
		for( iter = length/2 ; iter >= 0; iter--){
			heapifyMax(arr,iter,length);
		}

		for(iter = length-1; iter >=0 ;iter--){
			swap(arr,iter,0);
			heapifyMax(arr,0,iter);
		}
	}

	static void printArray(int[] arr){
		for(int a: arr){
			System.out.print(a + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args){
		int[] arr = {4,5,2,3,6,8,1,9,1,2,5,6,3,10,12};
		heapSort(arr);
		printArray(arr);
	}
}