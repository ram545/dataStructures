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

class SLenOfSubStr{
	static MyStack ms;
	SLenOfSubStr(){	
		ms = new MyStack();
	}

	static int maxSubString(String s){
		int iter = 0, length = s.length(),a,b,len=0;
		while(iter < length){
			if(ms.isEmpty())
				ms.push(new Pair(s.charAt(iter),iter));
			else{
				if(s.charAt(iter) == ')' && ms.peek().getKey() == '(')
					ms.pop();
				else 
					ms.push(new Pair(s.charAt(iter),iter));
			}
			iter++;
		}

		if(ms.isEmpty())
			return length;

		a = length;

		while(!ms.isEmpty()){
			b = ms.peek().getCount();
			b++;
			ms.pop();
			if(ms.isEmpty() && b != 0)
				ms.push(new Pair('d',-1));
			len = (len > (a-b)) ? len : (a-b);
			a = b-1;
		}
		return len;
	}

	public static void main(String[] args){
		SLenOfSubStr dummy = new SLenOfSubStr();
		String s = "((()";
		int result = maxSubString(s);
		System.out.println(result);
	}
}