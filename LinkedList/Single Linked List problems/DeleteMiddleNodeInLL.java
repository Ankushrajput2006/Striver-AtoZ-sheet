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
public class DeleteMiddleNodeInLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = deleteMiddleNode(head);

        System.out.println("Linked List after deleting the middle node:");
        printList(head);
    }
    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        Node slowPointer = head;
        Node fastPointer = head.next.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer by 1
            fastPointer = fastPointer.next.next; // Move fast pointer by 2
        }
        // Delete the middle node
        slowPointer.next = slowPointer.next.next; // Bypass the middle node
        return head; // Return the modified list
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
