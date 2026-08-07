class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class CopyListWithRandomPointers {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next; // 1's random points to 3
        head.next.random = head; // 2's random points to 1
        head.next.next.random = head.next; // 3's random points to 2

        System.out.println("Original Linked List:");
        printList(head);

        Node copiedHead = copyRandomList(head);

        System.out.println("Copied Linked List:");
        printList(copiedHead);
    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next; // Set the random pointer for the copied node
            }
            current = current.next.next; // Move to the next original node
        }

        // Step 3: Separate the original and copied nodes
        Node pseudoHead = new Node(0);
        Node copyCurrent = pseudoHead;
        current = head;

        while (current != null) {
            copyCurrent.next = current.next; // Link the copied node
            copyCurrent = copyCurrent.next; // Move to the next copied node

            current.next = current.next.next; // Restore the original list
            current = current.next; // Move to the next original node
        }

        return pseudoHead.next; // Return the head of the copied list
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Node Value: " + temp.val);
            if (temp.random != null) {
                System.out.print(", Random points to: " + temp.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            temp = temp.next; // Move to the next node in the linked list
        }
    }
}
