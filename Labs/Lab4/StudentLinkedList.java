// Sumeir Khinda, V00933760

public class StudentLinkedList implements StudentList{

    private StudentNode head;
    private int count;

    public StudentLinkedList() {
        head = null;
        count = 0;
    }

    public void add (Student s) {
        StudentNode n = new StudentNode(s);
        
        if (head==null) {
            head = n;
        } else {
            StudentNode cur = head;
            while (cur.next!=null) {
                cur = cur.next;
            }
            cur.next = n;
        }
        count++;
    }

    public int size() {
        return count;
    }

    public String toString() {
        String s = "";

        StudentNode cur = head;
        while (cur!=null) {
            s += cur.getData().toString() + "\n";
            cur = cur.next;
        }
        return s;
    }

    public void removeFront() {
        if (head!=null)
            head = head.next;
        count--;
    }

    public boolean contains (Student s) {
        StudentNode cur = head;

        while (cur!=null) {
            if (cur.getData().equals(s))
                return true;
            cur = cur.next;
        }

        return false;
    }

}