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

public class AddTwoNumbersInLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(2, new Node(4, new Node(3)));
        Node l2 = new Node(5, new Node(6, new Node(4)));
        
        Node result = addTwoNumbers(l1, l2);
        
        printList(result); // Output: 7 -> 0 -> 8
    }
    
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;
        Node temp1 = l1;
        Node temp2 = l2;
        
        while (temp1 != null || temp2 != null) {
            int x = (temp1 != null) ? temp1.data : 0;
            int y = (temp2 != null) ? temp2.data : 0;
            
            int sum = x + y + carry;
            carry = sum / 10;
            
            current.next = new Node(sum % 10);
            current = current.next;
            
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        
        if (carry > 0) {
            current.next = new Node(carry);
        }
        
        return dummy.next;
    }
    
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
