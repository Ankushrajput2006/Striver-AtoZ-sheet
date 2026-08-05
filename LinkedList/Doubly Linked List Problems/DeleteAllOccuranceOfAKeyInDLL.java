
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
public class DeleteAllOccuranceOfAKeyInDLL {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        Node head=Arraytodll(arr);
        head=deleteAllOccurance(head,30);
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
    public static Node deleteAllOccurance(Node head,int key){
        if(head==null){
            return null;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                if(temp == head){
                    head=head.next;
                }
                Node nextNode=temp.next;
                Node prevNode=temp.prev;
                if(prevNode!=null){
                    prevNode.next=nextNode;
                }
                if(nextNode!=null){
                    nextNode.prev=prevNode;
                }
            }
            temp=temp.next;
        }
        return head;
    }   
}
