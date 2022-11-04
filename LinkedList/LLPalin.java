import java.io.*;
import java.util.Scanner;
import java.lang.String;

class LinkedList{
	 Node head;
	 Node comHead;

	static class Node{
		char value;
		Node next;

		Node(char value){
			this.value = value;
			this.next = null;
		}
	}	

	// inserts an element at the end of the list
	public void insertAtTail(char value){
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
	public void deleteNode(char key){
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

	public Node reverse(Node Head){
		Node current = Head, next = null, prev = null;
		while( current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public boolean checkPalindrome(){
		Integer count = getCount(), iter = 0;
		Node cHead1 = head, cHead2 = null;
		boolean flag = true;
		while( iter++ < (count/2)-1)
			cHead1 = cHead1.next;
		if(count%2 != 0){
			cHead1 = cHead1.next;
		}
		cHead1.next = reverse(cHead1.next);
		cHead1 = cHead1.next;
		iter = 0;
		cHead2 = head;
		count = count/2;
		while(iter++ < count){
			if(cHead1.value != cHead2.value){
				flag = false;
				break;
			}
			cHead1 = cHead1.next;
			cHead2 = cHead2.next;
		}
		return flag;
	}


	public boolean checkPalinSlowFast(){
		Node slow = null, fast = head;
		boolean isPalin = true;
		while(fast != null && fast.next != null){
			if(slow == null)
				slow = head;
			else 
				slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null && fast.next == null)
			slow = slow.next;

		slow.next = reverse(slow.next);
		fast = head;
		slow = slow.next;
		while( slow!= null && fast != null){
			if( slow.value != fast.value){
				isPalin = false;
				break;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return isPalin;
	}

	public boolean compareNodes(Node head, Node head1){
		System.out.println(head);
		if(head.value == head1.value){
			head1 = head1.next;
			return true;
		} 
		return false;
	}

	public boolean checkPalindromeRec(Node currHead){
		if(currHead == null)
			return true;

		if(checkPalindromeRec(currHead.next)){
			if(currHead.value == comHead.value){
				comHead = comHead.next;
				return true;
			} 
			return false;
		}
		return false;
	}


}

public class LLPalin{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		Integer iter = 0;
		String s = sc.nextLine();
		LinkedList ll = new LinkedList();
		s = s.toLowerCase();
		while(iter < s.length()){
			ll.insertAtTail(s.charAt(iter++));
		}
		ll.comHead = ll.head;
		System.out.println(ll.checkPalindromeRec(ll.head));
		//ll.printLinkedList();
		return;
	}

	
}