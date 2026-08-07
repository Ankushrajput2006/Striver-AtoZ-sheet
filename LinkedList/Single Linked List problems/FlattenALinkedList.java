class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
    Node(int d, Node next, Node bottom) {
        data = d;
        this.next = next;
        this.bottom = bottom;
    }
}
public class FlattenALinkedList {
     public static void main(String[] args) {
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        System.out.println("Original Linked List:");
        printList(head);

        Node flattenedHead = flattenLinkedList(head);

        System.out.println("Flattened Linked List:");
        printList(flattenedHead);   
}
       
    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the next linked list
        Node mergedNext = flattenLinkedList(head.next);

        // Merge the current linked list with the flattened next linked list
        head = mergeTwoLists(head, mergedNext);

        return head;
    }

    public static Node mergeTwoLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node dummy = new Node(0);
        Node current = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                current.bottom = a;
                a = a.bottom;
            } else {
                current.bottom = b;
                b = b.bottom;
            }
            current = current.bottom;
        }

        // Append any remaining nodes from either list
        if (a != null) {
            current.bottom = a;
        } else {
            current.bottom = b;
        }

        return dummy.bottom; // Return the actual head of the merged list
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom; // Move to the next node in the bottom list
        }
        System.out.println();
    }
}
