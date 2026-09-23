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
 class queue{
    static Node front = null;
    static Node rear = null;
    static int size=0;
    public static void push(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public static void pop(){
        if(front == null){
            System.out.println("Queue Underflow");
            return;
        }
        Node temp = front;
        front = front.next;
        temp.next = null;
        if(front == null){
            rear = null;
        }
        size--;
    }
    public static int top(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    public static int size(){
        return size;
    }

}
public class ImplementingQueueUsingLinkedList {
    public static void main(String[] args) {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.top());
        queue.pop();
        System.out.println(queue.top());
        System.out.println(queue.size());
    }
}
