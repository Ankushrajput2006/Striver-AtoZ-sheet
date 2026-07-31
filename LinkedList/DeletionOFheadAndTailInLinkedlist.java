
 class Node {
    int data;
    Node next;
        
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        }

        Node(int data) {
        this.data = data;
        this.next = null;
        }
    };

public class DeletionOFheadAndTailInLinkedlist {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50,60,70,80,90,100};
        Node head = Arraytoll(arr);
        head = deletehead(head);
        System.out.println(head.data);
        head = deletetail(head);
        Node temp = head;
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
    //delete head
    public static Node deletehead(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static Node deletetail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    
}
