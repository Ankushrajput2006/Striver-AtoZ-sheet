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
public class FindPairsWithGivenSumKInDLL {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        findPairsWithGivenSumK(head,130);
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
    public static List<List<Integer>> findPairsWithGivenSumK(Node head,int k){
        Node first=head;
        Node end = findLastNode(head);
        List<List<Integer>> pairs = new ArrayList<>();

        while(first.data<end.data){
            if(first.data+end.data==k){
                pairs.add(Arrays.asList(first.data, end.data));
            }
            else if(first.data+end.data<k){
                first=first.next;
            }
            else{
                end=end.prev;
            }
        }
        return pairs;
    }
    public static Node findLastNode(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
}
