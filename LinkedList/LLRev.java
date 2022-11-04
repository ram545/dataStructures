import java.io.*;
import java.util.Scanner;

class LinkedList{
	 Node head;

	static class Node{
		Integer value;
		Node next;

		Node(Integer value){
			this.value = value;
			this.next = null;
		}
	}

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

	public void reverse(){
		Node current = head, next = null, prev = null;
		while( current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void reverseK(Integer K){
		Node current = head, next = null, prev = null,tail = null, prevSave = null;
		Integer iter = 0;
		while( current != null){
			iter = 0;
			while(iter++ < K && current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			if( prevSave == null){
				prevSave = prev;
				tail = prev;
				while(tail.next != null)
					tail = tail.next;
			}
			else {
				tail.next = prev;
				while(tail.next != null)
					tail = tail.next;
			}
			prev = null;

		}
		head = prevSave;
	}

	public void reverseAlternateK(Integer K){
		Node current = head, prev = null, next = null, tail = null, currentHead = null;
		Integer iter = 0;
		while( current != null){
			iter = 0;
			while(iter < K && current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				iter++;
			}
			if(tail == null)
				tail = prev;
			else 
				tail.next = prev;
			while(tail.next != null)
				tail = tail.next;
			tail.next = current;

			while(iter < (2*K) && current != null){
				current = current.next;
				tail = tail.next;
				iter++;
			}	
			if(currentHead == null){
				currentHead = prev;
			}
			prev = null;	
		}
		head = currentHead;
	}

	public void addOne(){
		Integer carry = 1;
		Node current = head;
		while( current != null){
			if( carry == 1){
				if( current.value == 9)
					current.value = 0;
				else{
					current.value += 1;
					carry = 0;
				}
			}
			current = current.next;
		}

		if( carry == 1)
			insertAtTail(carry);
	}

	public void recursiveAddOne(){
		Node temp = head;
		boolean carry = addOne(temp);
		if(carry)
			insertAtHead(1);
	}

	public boolean addOne(Node temp){
		if( temp.next == null ){
			if(temp.value == 9){
				temp.value = 0;
				return true;
			}
			else{
				temp.value += 1;
				return false;
			}
		}
		else{
			if(addOne(temp.next)){
				if(temp.value == 9){
					temp.value = 0;
					return true;
				}
				else{
					temp.value += 1;
				}
			}
		}
		return false;
	}

	public Node reverseRec(Node currHead, Node prev){
		if( currHead == null) 
			return head;

		if(currHead.next == null){
			currHead.next = prev;
			head = currHead;
			return head;
		}

		Node next = currHead.next;
		currHead.next = prev;
		reverseRec(next, currHead);
		return head;
	}

	public Node reverseRec1(Node currHead){
		if( currHead == null)
			return head;

		if( currHead.next == null){
			head = currHead;
			return head;
		}

		Node rest = reverseRec1(currHead.next);
		rest.next = currHead;
		currHead.next = null;
		rest = rest.next;
		return rest;
	}

}

public class LLRev{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		Integer N = sc.nextInt();
		System.out.println("Enter the elements: ");
		Integer iter = 0, K;
		LinkedList ll = new LinkedList();
		while(iter++ < N){
			ll.insertAtTail(sc.nextInt());
		}
		// ll.reverse();
		// ll.addOne();
		// ll.reverse();
		ll.reverseRec1(ll.head);
		ll.printLinkedList();
		return;
	}
}