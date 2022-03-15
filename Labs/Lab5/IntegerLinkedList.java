public class IntegerLinkedList {
    
    
    private IntegerNode	head;
    private int		    count;
    
    
    public IntegerLinkedList() {
        head = null;
        count = 0;
    }
    /*
     *
     * Purpose: returns the size of this IntegerList
     *
     * Parameters: none
     *
     * Returns: int - the size
     *
     */
    public int size() {
        return count;
    }
    
    /*
     *
     * Purpose: adds element with i to the front of this Integerlist
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void addFront (int i) {
        IntegerNode n = new IntegerNode(i, head);
        
        head = n;
        
        count++;
        
    }
    
    
    /*
     *
     * Purpose: returns a String representation of this IntegerList
     *
     * Parameters: none
     *
     * Returns: String - the String representation
     *
     */
    public String toString() {
        String s = "";
        IntegerNode tmp = head;
        
        while (tmp!=null) {
            s += tmp.getElement();
            if(tmp.next!=null)
                s += " ";
            tmp = tmp.next;
        }
        
        return s;
    }
    
    /*
     *
     * Purpose: adds 1 to every element in this IntegerList
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    public void addOne() {
        IntegerNode tmp = head;
        
        while (tmp!=null) {
            int valPlusOne = tmp.getElement() + 1;
            tmp.setElement(valPlusOne);
            tmp = tmp.next;
        }
    }
    
    /*
     *
     * Purpose: recursively adds 1 to every element in this IntegerList
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    public void addOneRecursive() {
        addOneRecursiveHelper(head);
    }
    
    /*
     *
     * Purpose: recursively adds 1 to IntegerNode n and every element following n
     *
     * Parameters: IntegerNode - n
     *
     * Returns: nothing
     *
     */
    private void addOneRecursiveHelper(IntegerNode n) {
        if (n==null) {
            return;
        } else {
            
            // get data in current node and add 1 to it
            int valPlusOne = n.getElement() + 1;
            // set element in current node to valPlusOne
            n.setElement(valPlusOne);
            
            // add one to the elements in the  REST of the list
            addOneRecursiveHelper(n.next);
        }
    }
    
    /*
     *
     * Purpose: recursively doubles every element in this IntegerList
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    public void doubleAll() {
        doubleHelper(head);
    }

    /*
     *
     * Purpose: recursively doubles IntegerNode n and every element following n
     *
     * Parameters: IntegerNode - n
     *
     * Returns: nothing
     *
     */
    private void doubleHelper (IntegerNode n) {
        if (n==null) {
            return;
        } else {
            int valDouble = n.getElement() * 2;
            n.setElement(valDouble);
            doubleHelper(n.next);
        }
    }
    
    
    /*
     *
     * Purpose: recursively doubles every odd element in this IntegerList
     *  By "odd element" we mean the Node's element is an odd number
     *  NOT that it is at an odd position in the list
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    public void doubleOdd() {
        doubleOddHelper(head);
    }
    
    /*
     *
     * Purpose: recursively doubles every odd element in this IntegerList,
     * starting from IntegerNode n
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    private void doubleOddHelper (IntegrNode n) {
        if (n==null) {
            return;
        } else {
            if (n.getElement()%2==1) {
                n.setElement(n.getElement()*2);
            }
            doubleOddHelper(n.next);
        }
    }

    
    /*
     *
     * Purpose: recursively sums every element in this IntegerList
     *
     * Parameters: none
     *
     * Returns: int - the sum
     *
     */
    public int sum() {
        return sum(head);
    }
    
    
    /*
     *
     * Purpose: recursively sums element in IntegerNode n and every element following n
     *
     * Parameters: IntegerNode - n
     *
     * Returns: int - the sum
     *
     */
    private int sum(IntegerNode n) {
        if (n==null) {
            return 0;
        } else {
            int first = n.getElement();
            int sumRest = sum(n.next);
            
            return first + sumRest;
        }
    }
    
    /*
     *
     * Purpose: recursively computes the product of every element in this IntegerList
     *  Note: the product of an empty list is 1
     *
     * Parameters: none
     *
     * Returns: int - the product
     *
     */
    public int product() {
        productHelper(head);
    }
    
    /*
     *
     * Purpose: recursively computes the product of every element in this IntegerList,
     * starting from IntegerNode n
     *
     * Parameters: IntegerNode n
     *
     * Returns: int - the product
     *
     */
    private int productHelper (IntegerNode n) {
        if (n==null) {
            return 1;
        } else {
            first = n.getElement();
            productRest = productHelper(n.next);

            return first * productRest;
        }
    }

    
    /*
     *
     * Purpose: recursively doubles every element at an odd postion in this IntegerList
     *  the first  element in this list is at position 0 (is not odd)
     *  the second element in this list is at position 1 (is odd)
     *  the third  element in this list is at position 2 (is not odd)
     *  ...
     *
     * Parameters: none
     *
     * Returns: nothing
     *
     */
    public void doubleOddPositionValues() {
        doubleOddPositionValues(head, 0);
    }
    
    /*
     *
     * Purpose: recursively doubles element in IntegerNode n if n is at odd position
     *  and every element after n at odd positions
     *
     * Parameters: IntegerNode - n, int - position
     *
     * Returns: nothing
     *
     */
    private void doubleOddPositionValues(IntegerNode n, int position) {
        if (n==null) {
            return;
        } else {
            if (position % 2 != 0) {
                int doubleVal = n.getElement() * 2;
                n.setElement(doubleVal);
            }
            doubleOddPositionValues(n.next, position+1);
        }
    }
    
    
    /*
     *
     * Purpose: recursively determines whether every element in this IntegerList
     *      is sorted in ascending order
     *      {1, 2, 2, 5} is sorted in ascending order
     *      {3, 2, 2, 5} is not sorted in ascending order
     *
     * Parameters: none
     *
     * Returns: boolean - true if sorted, false otherwise
     *
     */
    // ToDo: implement and test this method
    public boolean isSorted() {
        isSortedHelper(head);
    }
    
    private boolean isSortedHelper(IntegerNode n) {
        if (n.next==null) {
            return true;
        } else {
            boolean thisPair = true;
            if (n.getElement()>n.next.getElement())
                thisPair = false;
            boolean rest = isSortedHelper(n.next);
            return thisPair && rest;
        }
    }
    
    
    /*
     *
     * Purpose: recursively determines whether all elements in this IntegerList are negative
     *
     * Parameters: none
     *
     * Returns: boolean - true if all negative, false otherwise
     *
     */
    public boolean allNegative() {
        allNegativeHelper(head);
    }
    
    private boolean allNegativeHelper (IntegerNode n) {
        if (n.next==null) {
            if (n.getElement()<0)
                return true;
            return false;
        } else {
            boolean thisElement = false;
            if (n.getElement()<0)
                thisElement = true;
            boolean rest = allNegativeHelper(n.next);
            return thisElement && rest;
        }
    }
    
    
}

