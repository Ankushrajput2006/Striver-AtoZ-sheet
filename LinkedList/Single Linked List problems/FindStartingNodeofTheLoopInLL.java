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
public class FindStartingNodeofTheLoopInLL {
 public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next; // Loop at node with value 2

        Node startingNode = findStartingNodeOfLoop(head);
        if (startingNode != null) {
            System.out.println("Starting node of the loop is: " + startingNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
    public static Node findStartingNodeOfLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        // Detect loop using Floyd's Cycle Detection Algorithm
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer by 1
            fastPointer = fastPointer.next.next; // Move fast pointer by 2

            if (slowPointer == fastPointer) {
                // Loop detected, now find the starting node of the loop
                slowPointer = head; // Move slow pointer to the head
                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.next; // Move both pointers by 1
                    fastPointer = fastPointer.next;
                }
                return slowPointer; // Starting node of the loop
            }
        }
        return null; // No loop detected
    }   
}
