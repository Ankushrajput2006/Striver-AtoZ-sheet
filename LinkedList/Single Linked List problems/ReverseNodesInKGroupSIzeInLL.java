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

public class ReverseNodesInKGroupSIzeInLL {
      public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        int k = 2; // Size of the group to reverse
        head = reverseKGroup(head, k);

        System.out.println("Linked List after reversing nodes in groups of " + k + ":");
        printList(head);
}
      public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevnNode = null;
        Node NextNode = null;
        while (temp != null) {
            Node kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                prevnNode.next = NextNode; // Connect the last processed node to the remaining nodes
                break; // Not enough nodes to reverse, exit the loop
            }
            NextNode = kthNode.next; // Store the next node after the kth node
            kthNode.next = null; // Temporarily break the link to reverse the group
            reverseList(temp); // Reverse the current group
            if(temp == head) {
                head = kthNode; // Update head if it's the first group
            } else {
                prevnNode.next = kthNode; // Connect the previous group's tail to the new head
            }
            prevnNode = temp; // Move prevnNode to the end of the reversed group
            temp = NextNode; // Move temp to the next group
        }
        return head;
    }
    private static Node findKthNode(Node head, int k) {
        Node current = head;
        for (int i = 1; i < k && current != null; i++) {
            current = current.next;
        }
        return current; // Return the kth node or null if not enough nodes
    }
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to the next node
        }
        return prev; // Return the new head of the reversed list
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