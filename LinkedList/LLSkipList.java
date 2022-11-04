import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    int value;
    Node[] next;

    Node(int value){
        this.value = value;
        next = new Node[42];
        for(int iter=0; iter < 42; iter++)
            next[iter] = null;
    }
}

class LLSkipList {
    Node head;
    int maxHeight;
    Node[] prev;
    public LLSkipList() {
        head = new Node(-1);
        maxHeight = 0;
        prev = new Node[40];
    }
    
    public boolean search(int target) {
        Node temp = generatePred(target);
        if(temp.next[0] == null || temp.next[0].value != target)
            return false;
        else 
            return true;
    }

    public Node generatePred(int num){
        int level = maxHeight;
        Node prevNode = null, currNode = null;
        while(level >= 0){
            currNode = head.next[level];
            prevNode = head;
            if(currNode == null)
                prev[level] = head;
            else{
                while(currNode != null &&  num > currNode.value){
                    prevNode = currNode;
                    currNode = currNode.next[level];
                }
                prev[level] = prevNode;
            }
            level--;
        }
        return prev[0];
    }
    
    public void add(int num) {
        Node nextNode = null, addNode = new Node(num);
        int level = 0;
        boolean isEligible = true;
        generatePred(num);
        while(isEligible && level <= maxHeight){
            nextNode = prev[level].next[level];
            prev[level].next[level] = addNode;
            addNode.next[level] = nextNode;
            level++;
            isEligible = coinToss();
        }
        while(isEligible){
            nextNode = head.next[level];
            head.next[level] = addNode;
            addNode.next[level] = nextNode;
            level++;
            isEligible = coinToss();
        }
        if( level > maxHeight)
            maxHeight = level-1;
    }
    

    // need to check cases when the element gets deleted at height and the head is empty there
    // elements not being properly deleted in some cases check that
    public boolean erase(int num) {
        Node temp = generatePred(num);
        if(temp.next[0] == null || temp.next[0].value != num)
            return false;
        int level = 0;
        while(level <= maxHeight && prev[level].next[level] != null){
            if(prev[level].next[level].value != num)
                break;
            prev[level].next[level] = prev[level].next[level].next[level];
            level++;
        }
        level = maxHeight;
        temp = head;
        while(level > 0){
            if(head.next[level] == null){
                maxHeight--;
            }
            else 
                break;
            level--;
        }
        return true;
    }

    // to simulate a coin toss
    public static boolean coinToss(){
        if(Math.random() > 0.5)
            return true;
        else
            return false;
    }

    public void printSkipList(){
        Node temp = head,temp1 = null;
        for(int level = 0; level <= maxHeight; level++){
            temp1 = temp.next[level];
            while(temp1 != null){
                System.out.print(temp1.value+ " ");
                temp1 = temp1.next[level];
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        LLSkipList sl = new LLSkipList();
        sl.add(3);
        sl.add(4);
        sl.add(2);
        sl.add(6);
        sl.add(2);
        sl.add(6);
        System.out.println(sl.search(4));
        System.out.println(sl.search(7));
        System.out.println(sl.search(2));
        System.out.println(sl.search(1));
        System.out.println(sl.search(6));
        System.out.println(sl.search(3));
        sl.printSkipList();
        System.out.println(sl.erase(3));
        sl.printSkipList();
        System.out.println(sl.erase(5));
        sl.printSkipList();
        sl.erase(6);
        sl.printSkipList();        
        sl.erase(2);
        sl.printSkipList();
        sl.erase(6);
        sl.printSkipList();
        System.out.println(sl.erase(4));
        sl.printSkipList();
        sl.erase(2);
        sl.printSkipList();
    }
}
