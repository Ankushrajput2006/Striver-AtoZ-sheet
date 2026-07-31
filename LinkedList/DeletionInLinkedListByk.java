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
/**
 * DeletionInLinkedListByk
 */
public class DeletionInLinkedListByk {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50,60,70,80,90,100};
        Node head = Arraytoll(arr);
        head = delete(head, 3); // Delete the node at position 3
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        head = deleteBYvalueNode(head, 50); // Delete the node with value
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node Arraytoll(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }
    public static Node delete(Node head,int k){
        if(head==null){
            return null;
        }
        if(k==1){
            return head.next;
        }
        Node temp=head;
        int count=0;
        Node prev=null;
        while(temp!=null){
          count++;
          if(count==k){
            prev.next=prev.next.next;
          }
          prev=temp;
          temp=temp.next;
    }
    return head;
}

public static Node deleteBYvalueNode(Node head,int value){
        if(head==null){
            return null;
        }
        if(head.data==value){
            return head.next;
        }
        Node temp=head;
        
        Node prev=null;
        while(temp!=null){
          
          if(temp.data==value){
            prev.next=prev.next.next;
            break;
          }
          prev=temp;
          temp=temp.next;
    }
    return head;
}
}