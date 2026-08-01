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
public class InsertionInLinkedListByKandVAL {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        Node head=Arraytoll(arr);
        head=insertAtK(head,3,25); // Insert 25 at position 3
        head=insertbeforevalue(head,40,35); // Insert 35 before the node with value 40
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
     
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
    public static Node insertAtK(Node head,int k,int data){
      if(head==null){
        if(k==1){
            return new Node(data);
        }else{
            return null;
      }
    }
    if(k==1){
        Node newNode=new Node(data,head);
        return newNode;
    }
    int count=0;
    Node temp=head;
    while(temp!=null){
        count++;
        if(count==k-1){
            Node newNode=new Node(data,temp.next);
            temp.next=newNode;
           break;
        }
        temp=temp.next;
    }
    return head;
}

  public static Node insertbeforevalue(Node head,int value,int data){
    if(head==null){
        return null;
    }
    if(head.data==value){
        Node newNode=new Node(data,head);
        return newNode;
    }
    Node temp=head;
    while(temp.next!=null){
        if(temp.next.data==value){
            Node newNode=new Node(data,temp.next);
            temp.next=newNode;
            break;
        }
        temp=temp.next;
    }
    return head;
}