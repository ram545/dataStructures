import java.io.*;
import java.util.Scanner;

class Node{
	Integer value;
	Node next;
	Node list;

	Node(Integer value){
		this.value = value;
		this.next = null;
		this.list = null;
	}
}

class LinkedList{
	 Node head;

	// insert at the start of the linked list
	public void insertAtHead(Integer val){
		Node n = new Node(val);
		n.next = head;
		head = n;
	}

	// Insert after a target value, if it exists
	public void insertAfter(Integer val, Integer target){
		Node temp, n = new Node(val);
		if(head == null)
			head = n;	
		else{	
			temp = head;
			while(temp != null && temp.value != target){
				temp = temp.next;
			}
			if( temp == null)
				System.out.println("No such element Found");
			else{
				n.next = temp.next;
				temp.next = n;
			}
		}
	}	

	// inserts an element at the end of the list
	public void insertAtTail(Integer value){
		Node temp,n = new Node(value);
		if(head != null){
			temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = n;
		}
		else
			head = n;
	}

	public void insertRight(Node head){
		Node temp;
		if(this.head == null)
			this.head = head;
		else{
			temp = this.head;
			while(temp.list != null){
				temp = temp.list;
			}
			temp.list = head;
		}
	}

	// check whether it is empty or not
	public boolean isEmpty(){
		return (head == null)? true : false;
	}

	// delete the node at the start of the list
	public void deleteHead(){
		head = head.next;
	}

	// deleted the node at the end of the list
	public void deleteTail(){
		Node temp = head,prev = null;
		if( temp.next == null)
			head = null;
		else{
			while(temp.next != null){
				prev = temp;
				temp = temp.next;
			}
			prev.next = null;
		}

	}

	// deletes a node with a certain value
	public void deleteNode(Integer key){
		Node temp = head,prev = null;

		if( temp != null && temp.value == key)
			head = temp.next;
		else{
			while( temp != null && temp.value != key){
				prev = temp;
				temp = temp.next;
			}

			if( temp == null)
				System.out.println("No such node found to delete");
			else
				prev.next = temp.next;
		}
	}

	// print a linked list
	public void printLinkedList(){
		Node iter = head;
		while( iter != null){
			System.out.print(iter.value + " ");
			iter = iter.next;
		}
		System.out.println("");
	}

	public void printDebugLinkedList(Node check){
		Node iter = check;
		while( iter != null){
			System.out.print(iter.value + " ");
			iter = iter.next;
		}
		System.out.println("");
	}

	public Integer getCount(){
		Node temp = head;
		Integer count = 0;
		while(temp!= null){
			temp = temp.next;
			count++;
		}
		return count;
	}

	public void printListOfList(){
		Node temp = head;
		while(temp != null){
			printDebugLinkedList(temp);
			temp = temp.list;
		}
	}

	public Node merge(Node a, Node b){
		if( a == null)
			return b;

		if( b == null)
			return a;

		Node rest;
		if( a.value > b.value) {
			rest = b;
			rest.next = merge(a,b.next);
		}
		else{
			rest = a;
			rest.next = merge(a.next,b);
		}
		return rest;
	}

	public Node flatten(Node head){
		if( head == null || head.list == null)
			return head;

		Node rest = flatten(head.list);
		rest = merge(rest,head);

		return rest;
	}

}

public class LLFlatten{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of lists: ");
		Integer N = sc.nextInt(),iter=0, iter1=0, M;
		LinkedList list = new LinkedList();
		while(iter++ < N){
			LinkedList ll = new LinkedList();
			iter1 = 0;
			System.out.println("Enter the number of Elements");
			M = sc.nextInt();
			System.out.println("Enter the Elements");
			while(iter1++ < M){
				ll.insertAtTail(sc.nextInt());
			}
			list.insertRight(ll.head);
		}
		list.printListOfList();
		list.head = list.flatten(list.head);
		list.printLinkedList();
		return;
	}
}