import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    String key;
    public Integer count;
    Node prev;
    Node next;

    Node(String key){
        this.key = key;
        prev = null;
        next = null;
        count = 1;
    }

    public String getKey(){
        return this.key;
    }

    @Override
    public String toString(){
        return (this.key + " Count: " + this.count);
    }
}

class DoubleLL{
    public Node head;
    public Node tail;

    DoubleLL(){
        head = null;
        tail = null;
    }

    public void insertHead(String key){
        Node newNode = new Node(key);
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

public class LLAllInOneDS{ 
    int maxCount;
    int minCount;
    HashMap<String, Node> nodeMap;
    HashMap<Integer, DoubleLL> countMap; 
    public LLAllInOneDS() {
        nodeMap = new HashMap<String, Node>();
        countMap = new HashMap<Integer, DoubleLL>();
        minCount = 0;
        maxCount = 0;
    }
    
    public void inc(String key) {
        DoubleLL dl = null;
        Node temp = null;
        if(nodeMap.containsKey(key)){
            temp = nodeMap.get(key);
            dl = countMap.get(temp.count);
            dl.removeNode(temp);
            countMap.put(temp.count,dl);
            temp.count++;
            if( dl.isEmpty() && minCount == (temp.count-1))
                minCount++;
            dl = countMap.get(temp.count);
            if( dl == null)
                dl = new DoubleLL();
            dl.insertHead(temp);
            temp = dl.getHead();
            countMap.put(temp.count,dl);
            nodeMap.put(key,temp);
        }
        else{
            dl = countMap.get(1);
            if( dl == null)
                dl = new DoubleLL();
            dl.insertHead(key);
            temp = dl.getHead();
            nodeMap.put(key,temp);
            countMap.put(1,dl);
            minCount = 1;
        }
        if(minCount == 0 && maxCount == 0){
            minCount = temp.count;
            maxCount = temp.count;
        }
        else{
            if( maxCount < temp.count)
                maxCount = temp.count;
            if( minCount > temp.count)
                minCount = temp.count;
        }
        System.out.println(maxCount + " " + minCount);
    }
    
    public void dec(String key) {
        Node temp = null;
        DoubleLL dl = null;
        int iter = 0;
        temp = nodeMap.get(key);
        dl = countMap.get(temp.count);
        dl.removeNode(temp);
        countMap.put(temp.count, dl);
        if(dl.isEmpty() && minCount == temp.count)
            minCount--;
        if(dl.isEmpty() && maxCount == temp.count)
            maxCount--;
        if(temp.count != 1){
            temp.count--;
            dl = countMap.get(temp.count);
            dl.insertHead(temp);
            temp = dl.getHead();
            nodeMap.put(key,temp);
            countMap.put(temp.count,dl);
            if(minCount > temp.count)
                minCount = temp.count;
        }
        else{
            if(dl.isEmpty() && minCount != maxCount){
                iter = minCount+2;
                while(iter < maxCount){
                    dl = countMap.get(iter);
                    if(!dl.isEmpty())
                        break;
                    iter++;
                }
                minCount = iter;
            }
            nodeMap.remove(key);
        }
        System.out.println(maxCount + " " + minCount);
    }
    
    public String getMaxKey() {
        if(maxCount == 0)
            return "";
        DoubleLL temp = countMap.get(maxCount);
        if( temp == null)
            return "";
        else 
            return temp.getHead().getKey();
    }
    
    public String getMinKey() {
        if(minCount == 0)
            return "";
        DoubleLL temp = countMap.get(minCount);
        if( temp == null)
            return "";
        else 
            return temp.getHead().getKey();
    }
    public static void main(String args[]){
        LLAllInOneDS lads = new LLAllInOneDS(); 
        lads.inc("hello");
        lads.inc("hello");
        lads.inc("hello");
        lads.inc("hello");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey()); 
        lads.inc("leet");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey()); 
        lads.dec("leet");
        lads.inc("leet");
        lads.inc("leet");
        lads.inc("leet");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey()); 
        lads.dec("hello");
        lads.dec("hello");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey());
        lads.dec("leet"); 
        lads.dec("leet");
        lads.dec("leet");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey());
        lads.dec("hello");
        lads.dec("hello");
        System.out.println(lads.getMaxKey());
        System.out.println(lads.getMinKey());
    }
}