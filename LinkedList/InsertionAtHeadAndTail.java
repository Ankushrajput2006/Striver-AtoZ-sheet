import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }   
    Node(int data){
        this.data=data;
        this.next=null;
    }
};
public class InsertionAtHeadAndTail {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        Node head=Arraytoll(arr);
        head=insertAtHead(head,5); // Insert 5 at the head
        head=insertAtTail(head,60); // Insert 60 at the tail
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

  public static Node Arraytoll(int[] arr){
        Node head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            tail.next=newNode;
            tail=newNode;
        }
        return head;
    }

    public static Node insertAtHead(Node head,int data){
        Node newNode=new Node(data,head);
        return newNode;
    }
    public static Node insertAtTail(Node head,int data){
        Node newNode=new Node(data);
        if(head==null){
            return newNode;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
}
