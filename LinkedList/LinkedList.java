
import java.util.*;
    class Node {
        int data;
        Node next;
        
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    };
   public class LinkedList { 
    public static void main(String[] args) {
        Node n1 = new Node(30);
        System.out.println(n1.data);
        int[] arr = {10, 20, 30, 40, 50};
        Node head = Arraytoll(arr);
        System.out.println(head.next.data);

        //TRAVERSE
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        //length
        int length = 0;
        temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        System.out.println("Length of the linked list: " + length);

        //search
        int key = 30;
        int result = ifpresent(head, key);
        System.out.println("Is " + key + " present in the linked list? " + (result == 1 ? "Yes" : "No"));
    }

    public static Node Arraytoll(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    public static int ifpresent(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return 1; // Key found
            }
            temp = temp.next;
        }
        return 0; // Key not found
    }
}   