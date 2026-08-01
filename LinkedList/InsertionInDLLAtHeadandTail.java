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
public class InsertionInDLLAtHeadandTail {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        head=insertbeforeHead(head,5);
        head=insertbeforeTail(head,110);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
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
    public static Node insertbeforeHead(Node head,int data){
        Node newNode=new Node(data,head,null);
        if(head!=null){
            head.prev=newNode;
        }
        return newNode;
    }
    public static Node insertbeforeTail(Node head,int data){
        if(head==null){
            return insertbeforeHead(head,data);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node back =temp.prev;
        Node newNode=new Node(data,temp,back);
        temp.next=newNode;
        back.next=newNode;
        return head;
    }
}
