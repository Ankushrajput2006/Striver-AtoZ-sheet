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

public class LengthOfLoopInLL {
     public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next; // Loop at node with value 2

        int loopLength = findLoopLength(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop in the linked list is: " + loopLength);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
}
   public static int findLoopLength(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer by 1
            fastPointer = fastPointer.next.next; // Move fast pointer by 2

            if (slowPointer == fastPointer) {
                // Loop detected, now calculate the length of the loop
                return calculateLoopLength(slowPointer);
            }
        }
        return 0; // No loop detected
    }

    private static int calculateLoopLength(Node meetingPoint) {
        Node current = meetingPoint;
        int length = 1;

        while (current.next != meetingPoint) {
            current = current.next;
            length++;
        }
        return length;
    }
}