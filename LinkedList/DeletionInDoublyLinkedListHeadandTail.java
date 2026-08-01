import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data,Node next,Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }   
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
        this.prev=null;
    }
    Node(Node prev,int data){
        this.data=data;
        this.next=null;
        this.prev=prev;
    }
};
public class DeletionInDoublyLinkedListHeadandTail {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        
    }
    public static Node Arraytodll(int[] arr){
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i],null,prev);
            prev.next=newNode;
            prev=newNode;
        }
        return head;
    }
    public static Node removehead(Node head){
        if(head==null||head.next==null){
            return null;
        }
        Node previous = head;
        head = head.next;
        head.prev = null;
        previous.next = null; // Clear the next reference of the old head
        return head;
    }
    public static Node removeTail(Node head){
        if(head==null||head.next==null){
            return null;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node previous=temp.prev;
        previous.next=null;
        temp.prev=null; // Clear the prev reference of the old tail
        return head;
    }

   }