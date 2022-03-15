// Sumeir Khinda, V00933760

public class StudentNode {

    private Student data;
    protected StudentNode next;


    public StudentNode(Student data) {
		this.data = data;
		next = null;
	}
    
    
	public StudentNode(Student data,StudentNode next) {
		this.data = data;
		this.next = next;
    }
    
	public StudentNode getNext() {
		return next;
    }
    
	public void setNext(StudentNode next) {
		this.next = next;
    }
    
	public Student getData() {
		return data;
    }
    
	public void setData(Student data) {
		this.data = data;
    }
    
}