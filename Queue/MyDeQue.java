import java.lang.*;
import java.io.*;
import java.util.*;

class MyDeQue{
	int front;
	int rear;
	int[] arr;
	int size;
	int capacity;
	double loadFactor;

	MyDeQue(){
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[4];
		capacity = 4;
		loadFactor = 0.75;
	}

	MyDeQue(int capacity){
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[capacity];
		this.capacity = capacity;
		loadFactor = 0.75;
	}

	MyDeQue(int capacity, int loadFactor){
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

	int peekFront(){
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		return arr[front];
	}

	int peekLast(){
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		return arr[rear];
	}

	boolean addFirst(int num){
		if(isFullQueue()){
			System.out.println("Queue Overflow");
			return false;
		}
		if( size >= (capacity*loadFactor))
			enLargeQueue();
		if(front == -1 || front == 0)
			front = capacity;
		arr[--front] = num;
		size++;
		if(rear == -1)
			rear = front;
		return true;
	}


	boolean addLast(int num){
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

	int removeFirst(){
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

	int removeLast(){
		int element;
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		element = arr[rear];
		if(front == rear){
			front = -1;
			rear = -1;
		}
		else {
			if(rear == 0)
				rear = capacity;
			rear--;
		}
		size--;
		return element;
	}

	void enLargeQueue(){
		int iter = 0, iter1 = 0;
		capacity *= 2;
		int[] newArr = new int[capacity];
		System.out.println("Triggered");
		if( front < rear){
		 	iter = front;
		 	iter1 = 0;
		 	while(iter <= rear)
		 		newArr[iter1++] = arr[iter++];
		}
		else{
			iter = front;
			iter1 = 0;
			while( iter < (capacity/2))
				newArr[iter1++] = arr[iter++];

			iter = 0;
			while( iter <= rear)
				newArr[iter1++] = arr[iter++];
		}
		front = 0;
		rear = iter1-1;
		arr = newArr;
	}
} 