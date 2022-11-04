#include<iostream>

using std::cin;
using std::cout;
using std::endl;

void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(size>0 && i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

void mergeArray(long arr[],long low,long mid,long mid1,long high){
	long lsize,msize,rsize,l=0,m=0,r=0,k=low;
	lsize = mid-low+1;
	msize = mid1-mid;
	rsize = high-mid1;
	long larr[lsize+1]={0};
	long marr[rsize+1]={0};
	long rarr[rsize+1]={0};
	for(int it = 0; it < lsize; it++)
		larr[it] = arr[low+it];
	for(int it = 0; it < msize; it++)
		marr[it] = arr[mid+1+it];
	for(int it = 0; it < rsize; it++)
		rarr[it] = arr[mid1+1+it];
	while( l < lsize && m < msize && r < rsize){
		if(larr[l] < marr[m] && larr[l] < rarr[r])
			arr[k++] = larr[l++];
		else if(marr[m] < larr[l] && marr[m] < rarr[r])
			arr[k++] = marr[m++];
		else
			arr[k++] = rarr[r++];
	}
	while( l < lsize && r < rsize){
		if(larr[l] < rarr[r])
			arr[k++] = larr[l++];
		else
			arr[k++] = rarr[r++];
	}
	while( l < lsize && m < msize){
		if(larr[l] < marr[m])
			arr[k++] = larr[l++];
		else
			arr[k++] = marr[m++];
	}
	while( m < msize && r < rsize){
		if(marr[m] < rarr[r])
			arr[k++] = marr[m++];
		else
			arr[k++] = rarr[r++];
	}
	while(l<lsize)
		arr[k++] = larr[l++];	
	while(m<msize)
		arr[k++] = marr[m++];
	while(r<rsize)
		arr[k++] = rarr[r++];
	return;
}

void mergeSort(long arr[],long low,long high){
	if( low >= high )
		return;
	long mid,mid1;
	mid = low + (high-low)/3;
	mid1 = mid + (high-low)/3 + 1;
	mergeSort(arr,low,mid);
	mergeSort(arr,mid+1,mid1);
	mergeSort(arr,mid1+1,high);
	mergeArray(arr,low,mid,mid1,high);
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