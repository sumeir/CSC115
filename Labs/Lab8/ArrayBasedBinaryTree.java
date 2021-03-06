/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 100;
    protected Integer[] data;
    protected int root;
    protected int size;
    
    public ArrayBasedBinaryTree() {
        data = new Integer[CAPACITY];
        root = 0; // 0-based representation
        size = 0; // keeps track of index where the next element is to be inserted, and it's also the size 
    }
    
    /*
     * Purpose: inserts the given value into data at next available
     *  position in a level-order traversal
     *  The tree remains complete after insertion.
     * Parameters: Integer value - value to insert
     * Returns: nothing
     */
    public void insert(Integer value) {
        data[size] = value;
        size++;
    }
    
    
    /*
     * Purpose: calculates and returns the index of t's left child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of left child
     */
    protected int getLeft(int t) {
        return 2*t+1;
    }
    
    /*
     * Purpose: calculates and returns the index of t's right child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of right child
     */
    protected int getRight(int t) {
        return 2*t+2;
    }
    
    
    public void inOrder(){
        inOrder(0);
    }

    public void inOrder(int t) {
        if (data[t]==null) {
            return;
        } else {
            inOrder(getLeft(t));
            System.out.print(data[t]+" ");
            inOrder(getRight(t));
        }
    }
    
    
    public void preOrder(){
        preOrder(0);
    }
    
    public void preOrder(int t) {
        if (data[t]==null) {
            return;
        } else {
            System.out.print(data[t]+" ");
            preOrder(getLeft(t));
            preOrder(getRight(t));
        }
    }
    
    public void postOrder(){
        postOrder(0);
    }
    
    public void postOrder(int t) {
        if (data[t]==null) {
            return;
        } else {
            postOrder(getLeft(t));
            postOrder(getRight(t));
            System.out.print(data[t]+" ");
        }
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i<size; i++) {
            s += data[i]+" ";
        }
        return s;
    }
    
    
    
    public static void main(String[] args) {
        
        ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("in");
        myTree.inOrder();
        System.out.println();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println();
        System.out.println("post");
        myTree.postOrder();
        System.out.println();
        
        System.out.println("toString\n" + myTree);
    }
    
}
