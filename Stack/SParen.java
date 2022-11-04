import java.util.*;
import java.lang.*;
import java.io.*;

class MyStack{
	int capacity;
	double loadFactor;
	char[] arr;
	int top;
	
	MyStack(){
		arr = new char[4];
		this.capacity = 4;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity){
		arr = new char[capacity];
		this.capacity = capacity;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity, int loadFactor){
		arr = new char[capacity];
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
		char[] newArr = new char[newCap];
		System.out.println("enlarging the stack");
		for( iter = 0; iter <= (capacity*loadFactor); iter++){
			newArr[iter] = arr[iter];
		}
		arr = newArr;
		capacity = newCap;
	}	

	public void push(char val){
		if(top < (loadFactor*capacity))
			arr[++top] = val;
		else{
			enlargeStack();
			arr[++top] = val;
		}
	}

	public char peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Character.MIN_VALUE;
		}
		else 
			return arr[top];
	}

	public char pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Character.MIN_VALUE;
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

class SParen{
	static MyStack ms;
	SParen(){
		ms = new MyStack();
	}

	public static boolean isClosedParam(char c){
		if( c == '}' || c == ']' || c == ')')
			return true;
		else 
			return false;
	}

	public static boolean checkBalance(String s){
		int length = s.length(), iter = 0;
		boolean check = true;
		while(iter < length){
			if(isClosedParam(s.charAt(iter))){
				if( (s.charAt(iter) == '}' && ms.peek() == '{') || (s.charAt(iter) == ']' && ms.peek() == '[') || (s.charAt(iter) == ')' && ms.peek() == '(') )
					ms.pop();
				else{
					check = false;
					break;
				}
			}
			else{
				ms.push(s.charAt(iter));
			}
			iter++;
		}
		if(!ms.isEmpty())
			check = false;
		return check;	
	}

	public static void main(String args[]){
		//Scanner sc = new Scanner(System.in);
		//String s = sc.nextLine();
		SParen sp = new SParen();
		String s = "[]()";
		if(checkBalance(s))
			System.out.println("Balanced");
		else
			System.out.println("UnBalanced");
	}
}