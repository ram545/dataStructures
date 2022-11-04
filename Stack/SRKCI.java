import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
	char key;
	int count;
	Pair(char key, int count){
		this.key = key;
		this.count = count;
	}

	public char getKey(){
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
			return new Pair(Character.MIN_VALUE,0);
		}
		else 
			return arr[top];
	}

	public Pair pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return new Pair(Character.MIN_VALUE,0);
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

class SRKCI{
	static MyStack ms;
	SRKCI(){	
		ms = new MyStack();
	}

	static String reverse(String s){
		String result = "";
		int iter = s.length();
		while(iter-- > 0){
			result += s.charAt(iter);
		}
		return result;
	}

	static String removeKConsOccurence(String s,int K){
		int iter = 0, length = s.length(),val;
		String result = "";
		while(iter < length){
			if(ms.isEmpty())
				ms.push(new Pair(s.charAt(iter),1));
			else{
				System.out.println(ms.peek());
				if(ms.peek().getKey() == s.charAt(iter)){
					val = ms.peek().getCount();
					val++;
					ms.pop();
					if(val < K)
						ms.push(new Pair(s.charAt(iter),val));
				}
				else{
					ms.push(new Pair(s.charAt(iter),1));
				}
			}
			iter++;
		}
		while(!ms.isEmpty()){
			result = ms.peek().getKey()+result;
			ms.pop();
		}
		return result;
	}

	public static void main(String[] args){
		SRKCI dummy = new SRKCI();
		int K = 3;
		String s = "qfddxxxdjl";
		String result = removeKConsOccurence(s,K);
		System.out.println(result);
	}
}