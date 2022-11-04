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
	long size,temp=0,key,j;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements to be sorted" << endl;
	long arr[size];
	while(temp < size){
		cin >> arr[temp++];
	}

	// for(int i = 0; i != size-1; i++){
	// 	for(int j = i+1; j != 0; j--){
	// 		if(arr[j-1] > arr[j])
	// 			swap(&arr[j-1],&arr[j]);
	// 	}
	// }

	for( long i = 1; i != size; i++){
		key = arr[i];
		j = i-1;
		while( j >= 0 && arr[j] > key){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}


	cout << "The sorted array is" << endl;

	for(auto c: arr){
		cout << c << " ";
	}
	cout << endl;
	return 0;
}