// Sumeir Khinda, V00933760

public class A4Stack<T> implements Stack<T> {
	
	private static final int DEFAULT_CAPACITY = 5;
	private T[] data;
	private int top;

	public A4Stack() {
		data = (T[]) new Object[DEFAULT_CAPACITY];
		top = 0;
	}
	
	public A4Stack(int size) {
		data = (T[]) new Object[size];
		top = 0;
	}
	
	public void push(T v) throws FullStackException {
		if (isFull()) {
			throw new FullStackException("Can't push " + v + ", stack full.");
		} else {
			data[top] = v;
			top++;
		}
	}
	
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Can't pop, stack empty.");
		} else {
			T v = top();
			top--;
			data[top] = null;
			return v;
		}
	}
	
	public void popAll() {
		data = (T[]) new Object[data.length];
		top = 0;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public boolean isFull() {
		return data.length == top;
	}
	
	public T top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Can't access the top item, stack empty.");
		} else {
			return data[top-1];
		}
	}
}