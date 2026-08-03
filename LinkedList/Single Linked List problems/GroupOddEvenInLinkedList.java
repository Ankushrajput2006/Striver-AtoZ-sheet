class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}

public class GroupOddEvenInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        head = groupOddEven(head);
        printList(head); // Output: 1 -> 3 -> 5 -> 2 -> 4
    }
    public static Node groupOddEven(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // Keep the head of even nodes
        
        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd node to the next odd node
            odd = odd.next; // Move odd pointer
            
            even.next = odd.next; // Link even node to the next even node
            even = even.next; // Move even pointer
        }
        
        odd.next = evenHead; // Link the end of odd list to the head of even list
        return head;
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
