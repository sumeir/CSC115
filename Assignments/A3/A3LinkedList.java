// Name: Sumeir Khinda
// V#: V00933760

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node n = new A3Node(s);
		if (head==null) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head.setPrev(n);
			head = n;
		}
		length++;
	}

	public void addBack(String s) {
		A3Node n = new A3Node(s);
		if (head==null) {
			head = n;
			tail = n;
		} else {
			n.setPrev(tail);
			tail.setNext(n);
			tail = n;
		}
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if (length==1) {
			head = null;
			tail = null;
			length = 0;
		} else if (head!=null) {
			head = head.next;
			head.prev = null;
			length--;
		}
	}
	
	public void removeBack() {
		if (length==1) {
			head = null;
			tail = null;
			length = 0;
		} else if (head!=null) {
			tail.prev.next = null;
			tail = tail.prev;
			length--;
		}
	}
	
	public void rotate(int n) {
		if ((n%length)==0) return;

		A3Node cur = head;
		for(int i=1; i<length-1; i++) cur=cur.next;
		A3Node temp = cur;
		while(cur.next!=null) cur=cur.next;
		tail.next = head;
		temp.next = null;
		head.prev = tail;
		tail.prev = null;
		tail = temp;
		head = cur;

		rotate((n%length)-1);
	}
	
	public void interleave(A3LinkedList other) {
		A3Node cur1 = head;
		A3Node cur2 = other.head;
		A3Node temp1, temp2;

		while (cur1.next!=null && cur2.next!=null) {
			// save next pointers
			temp1 = cur1.next;
			temp2 = cur2.next;
			// interleave  
			cur1.next = temp2;
			temp2.prev = cur1;
			cur2.next = temp1;
			temp1.prev = cur2;
			// update pointers for next iteration
			cur1 = temp1;
			cur2 = temp2;
		}

	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	