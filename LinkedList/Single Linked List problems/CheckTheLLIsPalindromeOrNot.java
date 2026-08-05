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
public class CheckTheLLIsPalindromeOrNot {
   public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean isPalindrome = checkPalindrome(head);
        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
    public static boolean checkPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single node is a palindrome
        }

        // Find the middle of the linked list
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer by 1
            fastPointer = fastPointer.next.next; // Move fast pointer by 2
        }

        // Reverse the second half of the linked list
        Node secondHalfHead = reverseList(slowPointer);

        // Compare the first half and the reversed second half
        Node firstHalfPointer = head;
        Node secondHalfPointer = secondHalfHead;

        while (secondHalfPointer != null) {
            if (firstHalfPointer.data != secondHalfPointer.data) {
                reverseList(secondHalfPointer);
                return false; // Not a palindrome
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        reverseList(secondHalfPointer);
        return true; // The linked list is a palindrome
    }
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to the next node
        }

        return prev; // New head of the reversed list
    }   
}
