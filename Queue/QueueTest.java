import java.lang.*;
import java.io.*;
import java.util.*;

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

	public void swap(Node[] arr,int a, int b){
		Node temp = arr[a];
		arr[a] = arr[b];
	 	arr[b] = temp;
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
			swap(queue, N, largest);
			heapifyMax(largest,length);
		}
	}

	public void enQueue(int num, int priority){
		Node newNode = new Node(num,priority);
		int iter = 0;
		if(front >= capacity*loadFactor)
			reSizeContainer();
		queue[++front] = newNode;

		iter = front/2;
		while(iter >= 0){
			heapifyMax(iter,front+1);
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
		swap(queue, 0, front);
		front--;
		iter = front/2;
		while(iter >= 0){
			heapifyMax(iter,front+1);
			iter--;
		}
		return temp.data;
	}	

	public int top(){
		if(isEmpty())
			return -1;
		return queue[0].data;
	}

	public void printTree(){
		int iter=0;
		while(iter <= front){
			System.out.print(queue[iter].data + " ");
			iter++;
		}
		System.out.println("");
	}

}

class QueueTest{
	static priorityQueue que;

	QueueTest(){
		que = new priorityQueue();
	}

	public static void main(String args[]){
		QueueTest qt = new QueueTest();
		que.enQueue(2,5);
		que.enQueue(4,4);
		que.enQueue(6,2);
		que.enQueue(1,8);
		que.enQueue(3,4);
		System.out.println(que.top());
		que.deQueue();
		System.out.println(que.top());
		que.deQueue();
		que.printTree();
		que.deQueue();
		que.printTree();
		que.enQueue(9,2);
		que.enQueue(10,1);
		que.enQueue(12,8);
		que.deQueue();
		que.printTree();
		que.deQueue();
		que.printTree();
		System.out.println(que.top());
	}
}