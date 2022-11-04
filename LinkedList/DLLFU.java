import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    Integer val;
    Integer key;
    public Integer count;
    Node prev;
    Node next;

    Node(Integer val){
        this.key = 0;
        this.val = val;
        prev = null;
        next = null;
        count = 1;
    }

    Node(Integer key,Integer val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
        count = 1;
    }

    void updateValue(Integer value){
        this.val = value;
    }

    Integer getValue(){
        return val;
    }

    @Override
    public String toString(){
        return (this.key + " " + this.val + " Count: " + this.count);
    }
}

class DoubleLL{
    public Node head;
    public Node tail;

    DoubleLL(){
        head = null;
        tail = null;
    }

    public void insertHead(Integer key,Integer value){
        Node newNode = new Node(key,value);
        if(head == null){
            head = newNode;
            tail = head;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertHead(Node newNode){
        if(head == null){
            head = newNode;
            tail = head;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void removeTail(){
        if( tail == head || tail == null){
            head = null;
            tail = null;
        }
        else{
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
        }
    }

    public boolean isEmpty(){
        return (head == null) ? true : false;
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public void updateHead(Node head){
        this.head = head;
    }

    public void removeNode(Node temp){
        Node prev = null, next = null;
        prev = temp.prev;
        next = temp.next;
        if( prev == null && next == null ){
            head = null;
            tail = null;
        }
        else if( prev == null) {
            head = next;
            next.prev = null;
        }
        else if( next == null) {
            prev.next = null;
            tail = prev;
        }
        else{
            prev.next = next;
            next.prev = prev;
        }
        temp.next = null;
        temp.prev = null;
    }

    public void printList(){
        Node temp = head;
        System.out.println("Printing the list: ");
        while(temp != null){
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    } 
}


public class DLLFU {
    int capacity;
    int size;
    int minCount;
    HashMap<Integer, DoubleLL> countMap = null;
    HashMap<Integer, Node> keyNodeMap = null;
    public DLLFU(int capacity){
        countMap = new HashMap<Integer, DoubleLL>();
        keyNodeMap = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.size = 0;
        this.minCount = 1;
    }
    
    public int get(int key) {
        Node temp = null;
        DoubleLL dl = null;
        if(keyNodeMap.containsKey(key)){
            temp = keyNodeMap.get(key);
            dl = countMap.get(temp.count);
            dl.removeNode(temp);
            countMap.put(temp.count,dl);
            temp.count++;
            if( dl.isEmpty() && minCount == temp.count-1)
                minCount = temp.count;
            //System.out.println("min " + minCount);
            dl = countMap.get(temp.count);
            if( dl == null)
                dl = new DoubleLL();
            //dl.printList();
            dl.insertHead(temp);
            keyNodeMap.put(key, temp);
            countMap.put(temp.count,dl);
            //dl.printList();
            printLFU();
            return temp.getValue();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node temp = null,prev = null, next = null;
        DoubleLL tempList = null;
        if(capacity == 0)
            return;
        if(keyNodeMap.containsKey(key)){
            //System.out.println("Check");
            temp = keyNodeMap.get(key);
            temp.updateValue(value);
            get(key);
        }
        else{
            if(size < capacity){
                //System.out.println("Check 1");
                tempList = countMap.get(1);
                if( tempList == null)
                    tempList = new DoubleLL();
                tempList.insertHead(key,value);
            }
            else{
                //System.out.println("Check 2");
                tempList = countMap.get(minCount);
                temp = tempList.getTail();
                tempList.removeTail();
                keyNodeMap.remove(temp.key);
                //printLFU();
                countMap.put(minCount,tempList);
                tempList = countMap.get(1);
                tempList.insertHead(key,value);
            }
            countMap.put(1,tempList);
            minCount = 1;
            keyNodeMap.put(key,tempList.getHead());
            size++;
        }
        printLFU();
    }

    public void printLFU(){
        System.out.println("New Entry");
        for(Map.Entry<Integer, Node> e : keyNodeMap.entrySet()){
            System.out.println(e.getValue());
        }
    }

    public static void main(String args[]){
        DLLFU dl = new DLLFU(10);
        Integer a,b;
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        String temp;
        while(sc.hasNextLine()){
            temp = sc.nextLine();
            if(temp.equals("stop"))
                break;
            input.append(temp);
        }
        String[] arr = input.toString().split(" ");
        for( String s : arr){
            if(s.equals("put")){
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("put " + a + " " + b);
                dl.put(a,b);
                System.out.println("null");
            }
            else{
                a = sc.nextInt();   
                System.out.println("get " + a);
                System.out.println(dl.get(a));
            }
        }   
    }
}

