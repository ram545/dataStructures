import java.util.*;
import java.lang.*;
import java.io.*;


class Pair{
	int key;
	int count;
	Pair(int key, int count){
		this.key = key;
		this.count = count;
	}

	public int getKey(){
		return key;
	}

	public int getCount(){
		return count;
	}

	public void incCount(){
		count++;
	}

	@Override
	public String toString(){
		return (this.key + " " + this.count);
	}
}

class MyStack{
	int capacity;
	double loadFactor;
	Pair[] arr;
	int top;
	
	MyStack(){
		arr = new Pair[4];
		this.capacity = 4;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity){
		arr = new Pair[capacity];
		this.capacity = capacity;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity, int loadFactor){
		arr = new Pair[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		this.top = -1;
	}

	public boolean isEmpty(){
		return (top == -1)? true: false;
	}

	public void enlargeStack(){
		int newCap = 0, iter = 0;
		newCap = 2*capacity;
		Pair[] newArr = new Pair[newCap];
		for( iter = 0; iter <= (capacity*loadFactor); iter++){
			newArr[iter] = arr[iter];
		}
		arr = newArr;
		capacity = newCap;
	}	

	public void push(Pair val){
		if(top < (loadFactor*capacity))
			arr[++top] = val;
		else{
			enlargeStack();
			arr[++top] = val;
		}
	}

	public Pair peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return new Pair(-1,-1);
		}
		else 
			return arr[top];
	}

	public Pair pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return new Pair(-1,-1);
		}
		else{
			return arr[top--];
		}
	}

	public void printStack(){
		int iter = top;
		while( iter >= 0){
			System.out.print(arr[iter--] + " ");
		}
		System.out.println("");
	}
}

class SStockSpan{
	static MyStack ms;

	SStockSpan(){
		ms = new MyStack();
	}

	static int[] calcStockSpan(int[] arr){
		int iter = 0, length = arr.length, span =1;
		int[] result = new int[length];
		while(iter < length){
			span = 1;
			if(ms.isEmpty()){
				ms.push(new Pair(arr[iter],span));
				result[iter] = span;
			}
			else{
				while(!ms.isEmpty() && ms.peek().getKey() <= arr[iter]){
					span += ms.peek().getCount();
					ms.pop(); 
				}
				ms.push(new Pair(arr[iter],span));
				result[iter] = span;
			}
			iter++;
		}
		return result;
	}

	public static void printSpan(int[] arr){
		int iter = 0, length = arr.length;
		while(iter < length)
			System.out.print(arr[iter++] + " ");
		System.out.println("");
	}	

	public static void main(String args[]){
		SStockSpan span = new SStockSpan();
		int[] arr = new int[]{10,4,5,90,120,80};
		printSpan(arr);
		int[] result = calcStockSpan(arr);
		printSpan(result);
		//printSpan(result);
	}
}