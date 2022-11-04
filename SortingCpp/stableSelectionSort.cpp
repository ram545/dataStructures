#include<iostream>

using std::cin;
using std::cout;
using std::endl;


int main(){
	long minIdx,temp = 0,size,minElement;
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
		minElement = arr[minIdx];
		temp = minIdx;
		while(temp > i){
			arr[temp] = arr[temp-1];
			temp--;
		}
		arr[i] = minElement;
	}
	cout << "The sorted array is" << endl;

	for(auto c: arr){
		cout << c << " ";
	}
	cout << endl;
	return 0;
}