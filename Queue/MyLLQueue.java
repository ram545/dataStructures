import java.lang.*;
import java.io.*;
import java.util.*;

class Node{
	int element;
	Node next;

	Node(int element){
		this.element = element;
		this.next = null;
	}
}

class MyQueue{
	Node head;
	Node tail;

	MyQueue(){
		head = null;
		tail = null;
	}
	
	boolean isEmptyQueue(){
		return (head == null) ? true : false;
	}

	int front(){
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		return head.element;
	}

	boolean enQueue(int num){
		if(tail == null){
			tail = new Node(num);
			head = tail;
		}
		else{
			node newNode = new Node(temp);
			tail.next = newNode;
			tail = newNode;
		}

		return true;
	}

	int deQueue(){
		int element;
		if(isEmptyQueue()){
			System.out.println("Queue Underflow");
			return -1;
		}
		element = head.element;
		if(head == tail){
			head = null;
			tail = null;
		}
		else 
			head = head.next;
		return element;
	}

} 