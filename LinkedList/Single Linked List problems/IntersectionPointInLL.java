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

public class IntersectionPointInLL {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(9);
        head2.next = new Node(8);
        head2.next.next = head1.next.next; // Intersection at node with value 3

        int intersectionPoint = findIntersection(head1, head2);
        if (intersectionPoint != -1) {
            System.out.println("Intersection point is: " + intersectionPoint);
        } else {
            System.out.println("No intersection point found.");
        }
    }
    public static int findIntersection(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        if(current1 == null || current2 == null) {
            return -1; // No intersection if either list is empty
        }
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
            if(current1 == current2) {
                return current1.data; // Intersection point found
            }
            if (current1 == null) {
                current1 = head2; // Switch to the other list
            }
            if (current2 == null) {
                current2 = head1; // Switch to the other list
            }
        }
        return -1; // No intersection point found
    }
}
