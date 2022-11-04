#include<iostream>

using std::cin;
using std::cout;
using std::endl;

void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

void mergeArray(long arr[],long low,long high){
	long mid,lsize,rsize,i=0,j=0,k=low;
	mid = (low+high)/2;
	lsize = mid-low+1;
	rsize = high-mid;
	long larr[lsize+1]={0};
	long rarr[rsize+1]={0};
	for(int it = low; it <= mid; it++)
		larr[i++] = arr[it];
	for(int it = mid+1; it <= high; it++)
		rarr[j++] = arr[it];
	i = 0, j = 0;
	while( i < lsize && j < rsize){
		if(larr[i] < rarr[j])
			arr[k++] = larr[i++];
		else
			arr[k++] = rarr[j++];
	}
	while(i<lsize)
		arr[k++] = larr[i++];
	while(j<rsize)
		arr[k++] = rarr[j++];
	return;
}

void mergeSort(long arr[],long low,long high){
	if( low >= high )
		return;
	long mid = (low+high)/2;
	mergeSort(arr,low,mid);
	mergeSort(arr,mid+1,high);
	mergeArray(arr,low,high);
}

int main(){
	long size,temp=0,iter=0;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements" << endl;
	long arr[size] = {0};
	while(iter < size && cin >> temp)
		arr[iter++] = temp;
	mergeSort(arr,0,size-1);
	printArray(arr,size);
}