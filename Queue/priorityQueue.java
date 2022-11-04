import java.util.*;
import java.io.*;
import java.lang.*;

class priorityQueue{
	Node[] queue;
	int capacity;
	int front;
	double loadFactor;

	priorityQueue(){
		capacity = 4;
		queue = new Node[capacity];
		loadFactor = 0.75;
		front = -1;
	}

	class Node{
		int data;
		int priority;

		Node(int data, int priority){
			this.data = data;
			this.priority = priority;
		}
	}

	public void reSizeContainer(){
		int oldCapacity = capacity, iter = 0;
		capacity *= 2;
		Node[] newArr = new Node[capacity];
		while(iter < oldCapacity){
			newArr[iter] = queue[iter];
			iter++;
		}
		queue = newArr;
	}

	public void swap(Node a,Node b){
		Node temp = a;
		a = b;
	 	b= temp;
	}

	public void heapifyMax(int N, int length){
		int largest = N, left = 0, right = 0;
		left = 2*N+1;
		right = 2*N+2;

		if(left < length && queue[left].priority > queue[largest].priority)
			largest = left;

		if(right < length && queue[right].priority > queue[largest].priority)
			largest = right;

		if( largest != N){
			swap(queue[N], queue[largest]);
			heapifyMax(largest,length);
		}
	}

	public void enQueue(int num, int priority){
		Node newNode = new Node(num,priority);
		int iter = 0;
		if(front > capacity*loadFactor)
			reSizeContainer();
		queue[++front] = newNode;

		iter = front/2;
		while(iter >= 0){
			heapifyMax(iter,front);
			iter--;
		}
	}

	public boolean isEmpty(){
		return (front == -1)?true:false;
	}

	public int deQueue(){
		if(isEmpty()){
			System.out.println("Priority Queue is empty");
			return -1;
		}
		Node temp = queue[front];
		int iter = 0;
		swap(queue[0],queue[front]);
		front--;
		iter = front/2;
		while(iter >= 0){
			heapifyMax(iter,front);
			iter--;
		}
		return temp.data;
	}	

	public int top(){
		if(isEmpty())
			return -1;
		return queue[0].data;
	}

}