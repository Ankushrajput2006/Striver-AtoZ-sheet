
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
public class DoublyLinkedList {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        Node head=Arraytodll(arr);
        System.out.println(head.next.next.prev.data); // Should print 20
        head=traverse(head);
        System.out.println();
        Node foundNode=search(head,30);
        if(foundNode!=null){
            System.out.println("Node with value 30 found: " + foundNode.data);
        } else {
            System.out.println("Node with value 30 not found.");
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

    public static Node traverse(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        return head;
    }
    public static Node search(Node head,int key){
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}
