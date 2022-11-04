#include<iostream>

using std::cin;
using std::cout;
using std::endl;

long minm(long a, long b){
	return a>b ? b : a;
}

void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

void mergeArray(long arr[],long low,long mid,long high){
	long lsize,rsize,i=0,j=0,k=low;
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

void mergeSort(long arr[],long size){
	long currSize, lend, rend, mid;
	for(currSize = 1; currSize < size; currSize = 2*currSize){
		for(lend = 0; lend < size; lend += 2*currSize){
			mid = minm(lend+ currSize-1, size-1);
			rend = minm(lend+ 2*currSize-1, size-1);
			mergeArray(arr,lend,mid,rend);
		}
	}
}

int main(){
	long size,temp=0,iter=0;
	cout << "Enter the size of the array" << endl;
	cin >> size;
	cout << "Enter the elements" << endl;
	long arr[size] = {0};
	while(iter < size && cin >> temp)
		arr[iter++] = temp;
	mergeSort(arr,size);
	printArray(arr,size);
}