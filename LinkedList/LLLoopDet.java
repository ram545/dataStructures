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

	public Integer getCount(){
		Node temp = head;
		Integer count = 0;
		while(temp!= null){
			temp = temp.next;
			count++;
		}
		return count;
	}

	public void makeLoop(Integer X){
		Node end = head, joint = head;
		Integer iter = 0;
		while(end.next != null){
			end = end.next;
		} 

		while(iter++ < X){
			joint = joint.next;
		}

		end.next = joint;
	}


	public boolean checkLoop(){
		Node slow = head ,fast = head;
		if(fast.next != null && fast.next.next != null)
			fast = fast.next.next;
		else 
			return false;
		while(slow != fast){
			slow = slow.next;
			if(fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else 
				break;
		}
		if(slow == fast)
			return true;
		return false;
	}


	public void removeLoop(){
        Node slow = head ,fast = head;
		Integer count = 0,iter = 0;
		if(fast.next != null && fast.next.next != null)
			fast = fast.next.next;
		else 
			return;
		
		while(slow != fast){
			slow = slow.next;
			if(fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else 
				return;
		}
		do{
			fast = fast.next;
			count ++;
		}while(slow != fast);

		slow = head;
		fast = head;
		while(iter++ < count)
			fast = fast.next;

		while( slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		iter = 0;
		while( iter++ < (count-1)){
    	    fast = fast.next;
		}
		fast.next = null;
		return; 
	}

}

public class LLLoopDet{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		Integer N = sc.nextInt();
		System.out.println("Enter the elements: ");
		Integer iter = 0, X;
		LinkedList ll = new LinkedList();
		while(iter++ < N){
			ll.insertAtTail(sc.nextInt());
		}
		X = sc.nextInt();
		if(X != 0)
			ll.makeLoop(X-1);
		ll.removeLoop();
		ll.printLinkedList();
		return;
	}
}