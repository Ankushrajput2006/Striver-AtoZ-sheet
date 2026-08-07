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
public class MergeKSortedList {
    public static void main(String[] args) {

       Node head1 = new Node(1);
       head1.next = new Node(4);    
       head1.next.next = new Node(7);
         
         Node head2 = new Node(2);
        head2.next = new Node(5);
        head2.next.next = new Node(8);

        Node head3 = new Node(3);
        head3.next = new Node(6);
        head3.next.next = new Node(9);

        Node[] lists = {head1, head2, head3};
        System.out.println("K Sorted Linked Lists:");
        for (Node head : lists) {
            printList(head);
            System.out.println();
        }

        Node mergedHead = mergeKSortedLists(lists);

        System.out.println("Merged Sorted Linked List:");
        printList(mergedHead);
    }
    public static Node mergeKSortedLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKSortedListsHelper(lists, 0, lists.length - 1);
    }

    private static Node mergeKSortedListsHelper(Node[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        Node left = mergeKSortedListsHelper(lists, start, mid);
        Node right = mergeKSortedListsHelper(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private static Node mergeTwoLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node dummy = new Node(0);
        Node current = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from either list
        current.next = (a != null) ? a : b;

        return dummy.next; // Return the actual head of the merged list
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
