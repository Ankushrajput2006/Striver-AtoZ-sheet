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

public class SortLinkedListOfOs1s2s {
    public static void main(String[] args) {
        Node head = new Node(0, new Node(1, new Node(2, new Node(1, new Node(0, new Node(2))))));
        head = sortLinkedList(head);
        printList(head); // Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2
    }
    public static Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
       Node onehead = new Node(-1);
       Node twohead = new Node(-1);
       Node zerohead = new Node(-1);

       Node zero = zerohead;
       Node one = onehead;
       Node two = twohead;

       Node Temp = head;
       while (Temp != null) {
           if (Temp.data == 0) {
               zero.next = Temp;
               zero = zero.next;
           } else if (Temp.data == 1) {
               one.next = Temp;
               one = one.next;
           } else {
               two.next = Temp;
               two = two.next;
           }
           Temp = Temp.next;
       }
        zero.next = onehead.next != null ? onehead.next : twohead.next;
        one.next = twohead.next;
         two.next = null;
         return zerohead.next;
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
