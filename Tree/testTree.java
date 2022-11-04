import java.util.*;
import java.lang.*;
import java.io.*;

class MyTree{
	public Node root;

	MyTree(){
		root = null;
	}

	class Node{
		int data;
		Node left;
		Node right;


		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void inOrder(){
		inOrderRecursive(root);
	}

	private void inOrderRecursive(Node root){
		if(isEmpty(root))
			return;
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}

	public void inOrderIter(){
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while(true){
			while(!isEmpty(temp)){
				s.push(temp);
				temp = temp.left;
			}

			if(s.isEmpty())
				break;

			temp = s.pop();
			System.out.print(temp.data + " ");

			temp = temp.right;
		}

		System.out.println("");
	}

	public void postOrder(){
		postOrderRecursive(root);
	}

	private void postOrderRecursive(Node root){
		if(isEmpty(root))
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

	public void postOrderIter(){
		Stack<Node> s = new Stack<Node>();
		Node temp = root, previous = null;

		do{

			while(!isEmpty(temp)){
				s.push(temp);
				temp = temp.left;
			}

			while(isEmpty(temp) && !s.isEmpty()){
				temp = s.peek();
				if(temp.right == null || temp.right == previous){
					System.out.print(temp.data + " ");
					s.pop();
					previous = temp;
					temp = null;
				}
				else 
					temp = temp.right;
			}
		}while(!s.isEmpty());

		System.out.println("");
	}

	public void preOrder(){
		preOrderRecursive(root);
	}

	private void preOrderRecursive(Node root){
		if(isEmpty(root))
			return;
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	public void preOrderIter(){
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while(true){

			if(!isEmpty(temp)){
				System.out.print(temp.data + " ");

				if(temp.right != null)
					s.push(temp.right);

				if(temp.left != null)
					s.push(temp.left);
			}

			if(s.isEmpty())
				break;

			temp = s.pop();
		}

		System.out.println("");
	}

	public void preOrderIter1(){
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while(true){

			while(!isEmpty(temp)){
				System.out.print(temp.data + " ");
				s.push(temp);
				temp = temp.left;
			}

			if(s.isEmpty())
				break;

			temp = s.pop();
			temp = temp.right;
		}

		System.out.println("");
	}

	public void levelOrder(){
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		Node temp = root;
		if(isEmpty(temp)){
			System.out.println("Empty Tree");
			return;
		}
		que.add(temp);

		while(!que.isEmpty()){
			temp = que.removeFirst();
			System.out.print(temp.data + " ");

			if( temp.left != null)
				que.add(temp.left);

			if( temp.right != null)
				que.add(temp.right);
		}

	}

	public boolean isEmpty(){
		return (root == null) ? true : false;
	}

	private boolean isEmpty(Node root){
		return (root == null) ? true : false;
	}

	public boolean search(int key){
		return searchNode(root, key);
	}

	private boolean searchNode(Node root, int key){
		if(isEmpty(root))
			return false;

		if(root.data == key)
			return true;
		else if( root.data > key)
			return searchNode(root.left, key);
		else
			return searchNode(root.right, key);
	}

	public void insert(int num){
		root = insertNode(root, num);
	}

	private Node insertNode(Node root,int num){
		if(isEmpty(root)){
			root = new Node(num);
			root.left = null;
			root.right = null;
		}
		else{

			if( root.data > num)
				root.left = insertNode(root.left, num);
			else
				root.right = insertNode(root.right, num);
		}
		return root;
	}

	private boolean isLeafNode(Node root){
		return (root.left == null && root.right == null) ? true : false;
	}

	private void swap(Node a, Node b){
		int temp;
		temp = a.data;
		a.data = b.data;
		b.data = temp;
	}

	public void delete(int num){
		root = deleteNode(root,num);
	}

	public Node deleteNode(Node root, int num){
		if( root == null)
			return null;

		if( root.data == num){
			if(isLeafNode(root))
				return null;
			else if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else{
				Node temp = predecesor(root);
				swap(temp,root);
				root.left = deleteNode(root.left, num);
			}
		}

		else if( root.data > num)
			root.left = deleteNode(root.left, num);
		else 
			root.right = deleteNode(root.right,num);

		return root;
	}

	public Node predecesor(Node head){
		Node temp = head.left, predecesor = null;
		if( temp != null ){
			while( temp.right != null)
				temp = temp.right;
		}
		else{
			temp = root;
			while( temp.data != head.data){
				if( temp.data < head.data){
					if( predecesor == null)
						predecesor = temp;
					else if( predecesor.data < temp.data)
						predecesor = temp;
					temp = temp.right;
				}
				else 
					temp = temp.left;
			}
			temp = predecesor;
		}
		return temp;
	}

	public Node successor(Node head){
		Node temp = head.right, successor = null;
		if( temp != null){
			while( temp.left != null)
				temp = temp.left;
		}
		else{
			temp = root;
			while(temp.data != head.data){
				if(temp.data < head.data)
					temp = temp.right;
				else{
					if(successor == null)
						successor = temp;
					else{
						if(successor.data > temp.data)
							successor = temp;
					}
					temp = temp.left;
				}
			}
			temp = successor;
		}
		return temp;
	}

	public int height(){
		return treeHeight(root);
	}

	private int treeHeight(Node root){
		if(isEmpty(root))
			return 0;

		int left,right;
		left = treeHeight(root.left);
		right = treeHeight(root.right);

		return (left > right)? left+1 : right+1;
	}

	public int numberOfNodes(){
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		Node temp = null;
		int count = 0;
		if( root == null)
			return 0;
		que.add(root);

		while(!que.isEmpty()){
			temp = que.remove();
			count++;
			
			if(temp.left != null)
				que.add(temp.left);

			if(temp.right != null)
				que.add(temp.right);
		}

		return count;
	}

	public int findMin(){
		Node temp = root;
		while(temp.left != null)
			temp = temp.left;
		return temp.data;
	}


	public int findMax(){
		Node temp = root;
		while(temp.right != null)
			temp = temp.right;
		return temp.data;
	}
}

class testTree{
	static MyTree tt;

	testTree(){
		tt = new MyTree();
	}

	public static void main(String args[]){
		testTree mt = new testTree();
		tt.insert(10);
		tt.insert(3);
		tt.insert(6);
		tt.insert(15);
		tt.insert(7);
		tt.insert(12);
		tt.insert(11);
		tt.insert(9);
		tt.insert(20);
		System.out.println("");
		tt.inOrder();
		System.out.println("");
		tt.inOrderIter();
		tt.postOrderIter();
		tt.postOrder();
		System.out.println("");
		tt.preOrderIter();
		tt.preOrderIter1();
		tt.preOrder();
		System.out.println("");
		tt.levelOrder();
		System.out.println("");
		System.out.println("Number of Nodes: " + tt.numberOfNodes());
		System.out.println("Height: " + tt.height());
		System.out.println("Max Priority: " + tt.findMax());
		System.out.println("Min Priority: " + tt.findMin());
		System.out.println("predecesor: " + tt.successor(tt.root.left.right.right.right).data);
	}
}