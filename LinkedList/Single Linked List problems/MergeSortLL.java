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
public class MergeSortLL {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        Node sortedHead = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(sortedHead);
    }
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the linked list into two halves
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        // Recursively sort the two halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return mergeTwoLists(left, right);
    }
    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node mergeTwoLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node mergedHead = new Node(0); // Dummy node to simplify the merging process
        Node current = mergedHead;

        while (a != null && b != null) {
            if (a.data < b.data) {
                current.next = a;
                current = a;
                a = a.next;
            } else {
                current.next = b;
                current = b;
                b = b.next;
            }
        }
        // Append any remaining nodes from either list
        current.next = (a != null) ? a : b;

        return mergedHead.next; // Return the actual head of the merged list
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // Move to the next node in the linked list
        }
        System.out.println();
    }
}
