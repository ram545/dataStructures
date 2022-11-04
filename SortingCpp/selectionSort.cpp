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


int main(){
	long minIdx,temp = 0,size;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements to be sorted" << endl;
	long arr[size];
	while(temp < size){
		cin >> arr[temp++];
	}

	for(int i = 0; i != size-1; i++){
		minIdx = i;
		for(int j = i; j != size; j++){
			if(arr[minIdx] > arr[j])
				minIdx = j;
		}
		if(minIdx != i)
			swap(&arr[minIdx], &arr[i]);
	}
	cout << "The sorted array is" << endl;

	for(auto c: arr){
		cout << c << " ";
	}
	cout << endl;
	return 0;
}