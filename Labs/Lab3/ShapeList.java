// Sumeir Khinda, V00933760
public class ShapeList{
    
    private static final int INIT_SZ = 2;
    
    Shape[] elements;
    int count;
    
    public ShapeList() {
        elements = new Shape[INIT_SZ];
        count = 0;
    }
    
    /*
     * Purpose: returns the number of elements in list
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        return count;
    }
    
    /*
     * Purpose: adds Shape s to back of this list
     * Parameters: Shape - s
     * Returns: nothing
     */
    public void add (Shape s) {
        if (elements.length!=count) {
            elements[count] = s;
            count++;
        } else {
            Shape[] temp = new Shape[2*elements.length];
            for (int i=0; i<elements.length; i++)
                temp[i] = elements[i];
            elements = temp;
            add(s);
        }
        
    }
    
    /*
     * Purpose: returns a String reprensentation of the elements
     *      in this list separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        String str = "";
        for (int i=0; i<count; i++)
            str += elements[i] + "\n";
        return str;
    }
    
    /*
     * Purpose: removes the first element in this list
     * Parameters: none
     * Returns: nothing
     */
    public void removeFront() {
        Shape[] temp = new Shape[count-1];
        for (int i=0,j=1; j<count; i++,j++)
            temp[i]=elements[j];
        elements = temp;
        count--;
    }
    
    
}
