class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int middleValue = findMiddle(head);
        System.out.println("Middle value of the linked list is: " + middleValue);
    }
    public static int findMiddle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer by 1
            fastPointer = fastPointer.next.next; // Move fast pointer by 2
        }
        return slowPointer.data; // Slow pointer will be at the middle node
    }
}
