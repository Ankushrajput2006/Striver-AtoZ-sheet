class queue{
    int size = 5;
    int start = -1;
    int end = -1;
    int[] Q = new int[size];
    int currentSize = 0;
    void push(int item){
        if(currentSize == size){
            System.out.println("Queue Overflow");
            return;
        }
        if(currentSize == 0){
            start = 0;
            end = 0;
        }
        end = (end + 1) % size;
        Q[end] = item;
        currentSize++;
    }
    void pop(){
        if(currentSize == 0){
            System.out.println("Queue Underflow");
            return;
        }
        if(currentSize == 1){
            start = -1;
            end = -1;
        }
        start = (start + 1) % size;
        currentSize--;
    }
    int top(){
        if(currentSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return Q[start];
    }
    int size(){
        return currentSize;
    }
}
public class ImplementingQueueUsingArray {
    public static void main(String[] args) {
        queue queue = new queue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println(queue.top() + " is at the front of the queue");
        queue.pop();
        System.out.println(queue.top() + " is at the front of the queue");
    }
}
