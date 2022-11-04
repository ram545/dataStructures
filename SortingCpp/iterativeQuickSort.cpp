#include<iostream>

using std::cin;
using std::cout;
using std::endl;

void swaps(long *a,long *b){
	long temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

void printArray(long arr[],long size){
	long i=0;
	cout << "The sorted array is " << endl;
	while(i<size){
		cout << arr[i++] << " ";
	}
	cout << endl;
}

long partition(long arr[],long low,long high){
	long key = arr[high], start = low,j=low;
	while(j < high){
		if(arr[j] < key){
			swaps(&arr[start],&arr[j]);
			start++;
		}
		j++;
	}
	swaps(&arr[start],&arr[high]);
	return start;
}

void quickSort(long arr[],long low,long high){
	long stack[high+1]={0},top=-1,pos;
	stack[++top] = low;
	stack[++top] = high;
	while(top > 0){
		high = stack[top--];
		low = stack[top--];
		
		pos = partition(arr,low,high);

		if(pos > low+1){
			stack[++top] = low;
			stack[++top] = pos-1;
		}

		if(high > pos+1){
			stack[++top] = pos+1;
			stack[++top] = high;
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
	quickSort(arr,0,size-1);
	printArray(arr,size);
}