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
    static Node top = null;
    static int size=0;
    public static void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    public static void pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return;
        }
        top = top.next;
        size--;
    }
    public static int top(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    public static int size(){
        return size;
    }
}
public class ImplementingStackUsingLinkedList {
      public static void main(String[] args) {
        queue s = new queue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.size());
      }
    
}