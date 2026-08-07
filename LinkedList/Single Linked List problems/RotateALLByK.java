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
public class RotateALLByK {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        int k = 2; // Number of positions to rotate
        head = rotateList(head, k);

        System.out.println("Linked List after rotating by " + k + " positions:");
        printList(head);
    }
    public static Node rotateList(Node head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head; // No rotation needed
        }

        // Find the length of the linked list
        Node tail = head;
        int length = 1; // Start with 1 to count the head node
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Connect the last node to the head to make it circular
        tail.next = head;

        // Calculate the effective rotations needed
        k = k % length; // In case k is greater than the length of the list
        int stepsToNewHead = length - k;

        // Find the new tail and new head
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        head = newTail.next;

        // Break the circular link to finalize the rotation
        newTail.next = null;

        return head; // Return the new head of the rotated list
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
