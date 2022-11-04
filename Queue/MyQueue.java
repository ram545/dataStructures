import java.lang.*;
import java.io.*;
import java.util.*;

class MyQueue{
	int front;
	int rear;
	int[] arr;
	int size;
	int capacity;
	double loadFactor;

	MyQueue(){
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[4];
		capacity = 4;
		loadFactor = 0.75;
	}

	MyQueue(int capacity){
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[capacity];
		this.capacity = capacity;
		loadFactor = 0.75;
	}

	MyQueue(int capacity, int loadFactor){
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}
	
	boolean isEmptyQueue(){
		return (front == -1) ? true : false;
	}

	boolean isFullQueue(){
		return ((rear+1)%capacity == front) ? true : false;
	}

	int front(){
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		return arr[front];
	}

	boolean enQueue(int num){
		if(isFullQueue()){
			System.out.println("Queue Overflow");
			return false;
		}
		if( size >= (capacity*loadFactor))
			enLargeQueue();
		rear = (rear+1)%capacity;
		arr[rear] = num;
		size++;
		if(front == -1)
			front = rear;
		return true;
	}

	int deQueue(){
		int element;
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		element = arr[front];
		if(front == rear){
			front = -1;
			rear = -1;
		}
		else 
			front = (front+1)%capacity;
		size--;
		return element;
	}

	void enLargeQueue(){
		int iter = 0, iter1 = 0;
		capacity *= 2;
		int[] newArr = new int[capacity];
		if( front < rear){
		 	iter = front;
		 	iter1 = 0;
		 	while(iter <= rear)
		 		newArr[iter1++] = arr[iter++];
		}
		else{
			iter = rear;
			iter1 = 0;
			while( iter <= front)
				newArr[iter1++] = arr[iter++];
			front = 0;
			rear = iter1-1;
		}
		arr = newArr;
	}
} 