#include<iostream>

using std::cin;
using std::cout;
using std::endl;

//recursive
long binarySearch(long arr[], long low, long high, long key){
	long mid;
	if(low >= high)
		return (arr[low] > key) ? low : low+1;
	mid = (low+high)/2;
	if(arr[mid] == key)
		return mid+1;
	else if(arr[mid] > key)
		high = mid-1;
	else
		low = mid+1;
	return binarySearch(arr,low,high,key);
}

//iterative
long iBinarySearch(long a[],long low, long high, long key){
	long mid;
	while(low < high){
		mid = (low+high)/2;
		if(a[mid] == key)
			return mid+1;
		else if(a[mid] > key)
			high = mid-1;
		else
			low = mid+1;
	}
	return (a[low] > key) ? low : low+1;
}

void printArray(long arr[],long size){
	cout << "The sorted array list is" << endl;
	for(int i = 0; i != size; i++){
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main(){
	long size,temp=0,key,j,pos;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	long arr[size];
	cout << "Enter the elements of the array" << endl;
	while(temp < size){
		cin >> arr[temp++];
	}
	for( long i = 1; i != size; i++){
		key = arr[i];
		pos = iBinarySearch(arr,0,i-1,key);
		j = i-1;
		while(j >= pos){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}

	printArray(arr,size);
	return 0;
}