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
public class InsertionInDLLAtkthAndvalue {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        head=insertAtK(head,5,55);
       
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

    public static Node insertAtK(Node head,int k,int data){
        if(head==null){
            return new Node(data);
        }
        if(k==1){
            Node newNode=new Node(data,head,null);
            head.prev=newNode;
            return newNode;
        }
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k-1){
                break;
            }
            temp=temp.next;
        }
        Node back = temp.next;
        Node newNode=new Node(data,back,temp);
        temp.next=newNode;
        if(back!=null){
            back.prev=newNode;
        }
    }
}
