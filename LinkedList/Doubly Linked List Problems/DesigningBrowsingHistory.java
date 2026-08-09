class Node {
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
    Node(String url, Node prev, Node next) {
        this.url = url;
        this.prev = prev;
        this.next = next;
    }
}

public class DesigningBrowsingHistory {
    public static void main(String[] args) {
        Node head = new Node("https://www.example.com");
        head.next = new Node("https://www.google.com", head, null);
        head.next.next = new Node("https://www.github.com", head.next, null);

        System.out.println("Browsing History:");
        printHistory(head);
    }
    public static void printHistory(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.url);
            current = current.next;
        }
    }
}
class browser{
    Node current;
    public browser(Node head){
        this.current = head;
    }
    public void visit(String url){
        Node newNode = new Node(url);
        if(current != null){
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
    }
    public void back(int steps){
        while(steps > 0){
            if(current.prev != null){
                current = current.prev;
            }
            else{
                break;
            }
            steps--;
        }
    }
    public void forward(int steps){
        while(steps > 0){
            if(current.next != null){
                current = current.next;
            }
            else{
                break;
            }
            steps--;
        }
    }

} 
   
