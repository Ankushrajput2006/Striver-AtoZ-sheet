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
public class DeletionInDLLBykAndValue {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        head=removeAtK(head,5);
        removenode(head.next.next); // Remove the node with value 30
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }}

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

     public static Node removeAtK(Node head,int k){
        if(head==null){
            return null;
        }
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }
        Node previous=temp.prev;
        Node nextNode=temp.next;
        if(previous==null && nextNode==null){
            return null;
         }
        if(previous==null){
            nextNode.prev=null;
            temp.next=null;
            return nextNode;
}
        if(nextNode==null){
            previous.next=null;
            temp.prev=null;
            return head;
        }
        previous.next=nextNode;
        nextNode.prev=previous;
        temp.next=null;
        temp.prev=null;
        return head;
    }

    public static void removenode(Node temp){
        Node previous=temp.prev;
        Node nextNode=temp.next;
       if(nextNode==null){
            previous.next=null;
            temp.prev=null;
            return;
         }

        previous.next=nextNode;
        nextNode.prev=previous;
        temp.next=null;
        temp.prev=null;
    }}