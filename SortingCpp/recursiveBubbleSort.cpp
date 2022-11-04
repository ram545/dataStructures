#include<iostream>

using std::cin;
using std::cout;
using std::endl;

void swap(long* a1, long *a2){
	long temp;
	temp = *a1;
	*a1 = *a2;
	*a2 = temp;
}

void printArray(long arr[],long size){
	cout << "The sorted array list is" << endl;
	for(int i = 0; i != size; i++){
		cout << arr[i] << " ";
	}
	cout << endl;
}


void bubbleSort(long arr[], long size){
	bool swaps = false;
	if(size == 0 || size == 1)
		return;
	for(int i = 0; i != size-1; i++){
		if( arr[i] > arr[i+1]){
			swap(&arr[i],&arr[i+1]);
			swaps = true;
		}
	}
	if(!swaps)
		return;
	bubbleSort(arr, size-1);
}


int main(){
	long size,temp=0;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	long arr[size];
	cout << "Enter the elements of the array" << endl;
	while(temp < size){
		cin >> arr[temp++];
	}
	bubbleSort(arr,size);
	printArray(arr,size);
	return 0;
}