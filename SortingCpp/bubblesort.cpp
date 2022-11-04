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

int main(){
	bool swaps;
	long size,temp=0;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	long arr[size];
	cout << "Enter the elements of the array" << endl;
	while(temp < size){
		cin >> arr[temp++];
	}

	for(int i = 0; i != size; i++){
		swaps = false;
		for(int j = 0; j != size - (i+1); j++){
			if(arr[j] > arr[j+1]){
				swaps = true;
				swap(&arr[j],&arr[j+1]);
			}
		}
		if(!swaps)
			break;
	}

	printArray(arr,size);
	return 0;
}