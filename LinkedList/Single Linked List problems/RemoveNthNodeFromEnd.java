
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

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        int n = 2;
        head = removeNthFromEnd(head, n);
        printList(head); // Output: 1 -> 2 -> 3 -> 5
    }
    public static Node removeNthFromEnd(Node head, int n) {
        
        
        if (head == null || n <= 0) {
            return head;
        }
        if(n==length(head)){
            return head.next;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == length(head) - n) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static int length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}
