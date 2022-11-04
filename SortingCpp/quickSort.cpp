#include<iostream>

using std::cin;
using std::cout;
using std::endl;

void swaps(long *a,long *b){
	long temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

long partition(long arr[],long low,long high){
	long key = arr[high], start = low,j=low;
	while(j < high){
		if(arr[j] < key){
			swaps(&arr[start],&arr[j]);
			start++;
		}
		j++;
	}
	swaps(&arr[start],&arr[high]);
	return start;
}

// Tail Call Elimination
// we can eliminate half the recursions by using iterative plus recursive approach
// Normally, the function calls would take O(n) time but by eliminating one recursive call in each iteration
// and doing it iteratively decrease the space to O(logn)
void quickSort(long arr[],long low,long high){
	while(low < high){
		long pos = partition(arr,low,high);

		if(pos-low > high-pos){
			quickSort(arr,pos+1,high);
			high = pos-1;
		}

		if(pos-low <= high-pos){
			quickSort(arr,low,pos-1);
			low = pos+1;
		}
	}
}


// regular quick sort
// void quickSort(long arr[],long low,long high){
// 	if(low < high){
// 		long pos = partition(arr,low,high);

// 		quickSort(arr,low,pos-1);
// 		quickSort(arr,pos+1,high);
// 	}
// }

int main(){
	long size,temp=0,iter=0;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements" << endl;
	long arr[size] = {0};
	while(iter < size && cin >> temp)
		arr[iter++] = temp;
	quickSort(arr,0,size-1);
	printArray(arr,size);
}