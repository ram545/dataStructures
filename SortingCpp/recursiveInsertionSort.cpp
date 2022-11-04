#include<iostream>

using std::cin;
using std::cout;
using std::endl;


void insertionSort(long arr[],long n,long size){
	if( n == size || n == 0)
		return;
	long key,j;
	key = arr[n];
	j = n-1;
	while(j  >= 0 && arr[j] > key){
		arr[j+1] = arr[j];
		j--;
	}
	arr[j+1] = key;
	insertionSort(arr,n+1,size);
}


int main(){
	long temp = 0,size;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements to be sorted" << endl;
	long arr[size];
	while(temp < size){
		cin >> arr[temp++];
	}

	insertionSort(arr,1,size);

	cout << "The sorted array is" << endl;

	for(auto c: arr){
		cout << c << " ";
	}
	cout << endl;
	return 0;
}