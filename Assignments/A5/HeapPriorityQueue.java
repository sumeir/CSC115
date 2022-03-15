// Sumeir Khinda, V00933760
// I took this course in Spring 2020 as well, and this assignment is the exact same as one of the older assignments. If there is any similarity between 
// my implementations, it is purely due to me thinking about the solution the same way this time (which is very likely to happen), not copying from my earlier work. 

/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		currentSize = 0;
		storage = new Comparable[size];
	}

	public void insert ( Comparable element ) {
		if (currentSize>=storage.length) {
			throw new HeapFullException();
		} else {
			storage[currentSize] = element;
			bubbleUp(currentSize);
			currentSize++;
		}
	}
	
	public Comparable removeMin() {
		if (isEmpty()) {
			throw new HeapEmptyException();
		} else {
			Comparable val = storage[0]; // saving the min value to return later
			storage[0] = storage[currentSize-1]; // swap root with last element in the array (rightmost element on bottom level of tree)
			currentSize--; // now, effectively, the highest priority key is removed
			bubbleDown(0); // restoring the heap order property by repeatedly bubbling down
			return val;
		}
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public int size () {
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}


	// Helper Functions

	private int left (int t) {
		return 2*t+1;
	}

	private int right (int t) {
		return 2*t+2;
	}

	private int parent (int t) {
		return (t-1)/2;
	}

	private boolean isLeaf (int t) {
		return left(t)>=currentSize && right(t)>=currentSize;
	}

	private void swap (int a, int b) {
		Comparable temp = storage[a];
		storage[a]=storage[b];
		storage[b]=temp;
	}

	private void bubbleUp (int t) {
		while (t>0 && storage[parent(t)].compareTo(storage[t])>0) {
			swap(t,parent(t));
			t = parent(t);
		}
	}

	private void bubbleDown(int t){
		if(isLeaf(t)){
			return;
		}
		if(storage[left(t)].compareTo(storage[t])<0 || storage[right(t)].compareTo(storage[t])<0){
			if(storage[right(t)].compareTo(storage[left(t)])<0){
				swap(t, right(t));
				bubbleDown(right(t));
			} else {
				swap(t, left(t));
				bubbleDown(left(t));
			}
		}
	}

}
