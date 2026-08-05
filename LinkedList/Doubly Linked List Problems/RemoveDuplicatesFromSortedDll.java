
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
public class RemoveDuplicatesFromSortedDll {
    public static void main(String[] args) {
        int[] arr={10,20,20,30,40,50,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        head=removeDuplicates(head);
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
    public static Node removeDuplicates(Node head){
        if(head==null){
            return null;
        }
        Node current=head;
        while(current!=null && current.next!=null){
            Node nextNode=current.next;
            while(nextNode!=null && current.data==nextNode.data){
                nextNode=nextNode.next;
            }
            current.next=nextNode;
            if(nextNode!=null){
                nextNode.prev=current;
            }
            current=current.next;
        }
        return head;
    }  
}
