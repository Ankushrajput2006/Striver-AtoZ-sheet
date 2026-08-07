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
public class Merge2SortedLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        System.out.println("First Sorted Linked List:");
        printList(head1);

        System.out.println("Second Sorted Linked List:");
        printList(head2);

        Node mergedHead = mergeSortedLists(head1, head2);

        System.out.println("Merged Sorted Linked List:");
        printList(mergedHead);
    }

    public static Node mergeSortedLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node t1 = head1;
        Node t2 = head2;
        Node mergedHead = new Node(0); // Dummy node to simplify the merging process
        Node current = mergedHead;
        while (t1!=null && t2!=null) {
            if (t1.data < t2.data) {
                current.next = t1;
                current = t1;
                t1 = t1.next;
            } else {
                current.next = t2;
                current = t2;
                t2 = t2.next;
            }
        }
        // Append any remaining nodes from either list
        current.next = (t1 != null) ? t1 : t2;
        return mergedHead.next; // Return the actual head of the merged list
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
