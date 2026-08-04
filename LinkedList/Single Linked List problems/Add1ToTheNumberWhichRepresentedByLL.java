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
public class Add1ToTheNumberWhichRepresentedByLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printList(head);
        head = addOne(head);
        head = addOneByRecursion(head);
        printList(head);
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static Node addOne(Node head) {
        head = reverseList(head);
        Node current = head;
        int carry = 1; // Initialize carry as 1 for adding one
        
        while (current != null) {
            current.data += carry; // Add carry to current node's data
            if (current.data >= 10) {
                current.data = current.data % 10; // Keep only the last digit
                carry = 1; // Set carry for next node
            } else {
                carry = 0; // No carry needed
            }
            current = current.next; // Move to the next node
        }

        // If there's still a carry after processing all nodes, add a new node
       if(carry > 0) {
            Node newNode = new Node(carry);
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Append the new node at the end
        }

        return reverseList(head); // Reverse the list back to original order
    }
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current;      // Move prev to current
            current = next;      // Move to next node
        }
        return prev; // New head of the reversed list 
    }
    public static Node addOneByRecursion(Node head) {
        if (head == null) {
            return new Node(1); // If the list is empty, return a new node with value 1
        }
        
        int carry = addOneHelper(head);
        
        // If there's still a carry after processing all nodes, add a new node at the front
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode; // Update head to the new node
        }
        
        return head; // Return the updated head of the list
    }

    public static int addOneHelper(Node node) {
        if (node == null) {
            return 1; // Base case: if we reach the end of the list, return carry as 1
        }
        
        int carry = addOneHelper(node.next); // Recur for the next node
        
        node.data += carry; // Add carry to current node's data
        
        if (node.data >= 10) {
            node.data = node.data % 10; // Keep only the last digit
            return 1; // Return carry for the next node
        } else {
            return 0; // No carry needed
        }
    }   
}
