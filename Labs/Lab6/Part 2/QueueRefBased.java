// Sumeir Khinda, V00933760

public class QueueRefBased<T> implements Queue<T> {
    
    private QueueNode<T> front;
    private QueueNode<T> back;
    
    public QueueRefBased() {
        front = null;
        back = null;
    }
    
    public int size() {
        int count = 0;
        if (front!=null && back!=null) {
            QueueNode<T> cur = front;
            while (cur.next!=null) {
                count++;
                cur = cur.next;
            }
        }
        return count;
    }


    public boolean isEmpty() {
        return size()==0;
    }


    public void enqueue (T element) {
        QueueNode<T> n = new QueueNode<T>(element);
        if (front==null && back==null) {
            front = n;
            back = n;
        } else {
            back.next = n;
            back = n;
        }
    }

    public T dequeue() {
        QueueNode<T> n;
        if (front==back) {
            n = front;
            front = null;
            back = null;
        } else {
            n = front;
            front = front.next;
        }
        
        return n.getValue();
    }

    public T peek() {
        return front.getValue();
    }

    public void makeEmpty() {
        front = null;
        back = null;
    }
}

