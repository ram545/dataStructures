#include<iostream>

using std::cin;
using std::cout;
using std::endl;

#define N 4


void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

void merge(long input1[],long input2[],long size1,long size2,long output[]){
	long i=0,j=0,k=0;
	while(i < size1 && j < size2){
		if(input1[i] < input2[j])
			output[k++] = input1[i++];
		else
			output[k++] = input2[j++];

	}
	while(i < size1)
		output[k++] = input1[i++];
	while(j < size2)
		output[k++] = input2[j++];
}

void mergeKArrays(long arr[][4],long low,long high,long output[]){
	long mid = (high+low)/2;
	if(low == high){
		for(int i = 0; i < N; i++){
			output[i] = arr[low][i];
		}
	}
	else if(high-low == 1)
		merge(arr[low],arr[high],N,N,output);
	else{
		long out1[N*((mid-low)+1)];
		long out2[N*(high-mid)];
		mergeKArrays(arr,low,mid,out1);
		mergeKArrays(arr,mid+1,high,out2);
		merge(out1,out2,N*((mid-low)+1),N*(high-mid),output);
	}
}

int main(){
	long K,i=0,j=0;
	cout << "Enter the number of arrays:" << endl;
	cin >> K;
	cout << "Enter the elements in arrays " << endl;
	long output[N*K],arr[K][N] = {0};
	while(i<K){
		j=0;
		while(j<N)
			cin >> arr[i][j++];
		i++;
	}
	mergeKArrays(arr,0,K-1,output);
	printArray(output,K*N);
}