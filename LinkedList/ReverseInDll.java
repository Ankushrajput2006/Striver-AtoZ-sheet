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
public class ReverseInDll {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        Node head=Arraytodll(arr);
        head=reverse(head);
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static Node Arraytodll(int[] arr){
        Node head=new Node(arr[0]);
        Node tail=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i],null,tail);
            tail.next=newNode;
            tail=newNode;
        }
        return head;
    }
    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node current=head;
        Node temp=null;
        while(current!=null){
            temp=current.prev;
            current.prev=current.next;
            current.next=temp;
            current=current.prev;
        }
        if(temp!=null){
            head=temp.prev;
        }
        return head;
    }
}
