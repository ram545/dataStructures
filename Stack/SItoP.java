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


class SItoP{
	static MyStack ms;

	SItoP(){
		ms = new MyStack();
	}

	static int checkPriority(char ch){
		switch(ch){
			case '^': return 3;
			case '*':
			case '/': return 2;
			case '+':
			case '-': return 1;
			case '(': return 0;
		}
		return 0;
	}

	static String convertToPostfix(String s){
		String result = new String();
		int iter = 0, length = s.length();
		while( iter < length ){
			if(Character.isDigit(s.charAt(iter)) || Character.isLetter(s.charAt(iter)))
				result += s.charAt(iter);
			else if( s.charAt(iter) == '('){
				ms.push(s.charAt(iter));
			}
			else if( s.charAt(iter) == ')'){
				while( !ms.isEmpty() && ms.peek() != '('){
					result += ms.peek();
					ms.pop();
				}
				ms.pop();
			}
			else{
				while( !ms.isEmpty() && (checkPriority(s.charAt(iter)) <= checkPriority(ms.peek()))){
					result += ms.peek();
					ms.pop();
				}
				ms.push(s.charAt(iter));
			}
			iter++;
		}
		while(!ms.isEmpty()){
			if(ms.peek() == '('){
				System.out.println("Invalid Expression");
				result = " ";
				break;
			}
			result += ms.peek();
			ms.pop();
		}
		return result;
	}

	public static void main(String args[]){
		SItoP sip = new SItoP();
		String s = "((A+B)-C*((D/E))+F";
		String result = convertToPostfix(s);
		System.out.println(s + "\n" + result);
	}
}