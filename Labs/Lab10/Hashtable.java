// Sumeir Khinda, V00933760

public class Hashtable {
    
    private static final int TABLE_SZ = 7; // a prime number
    
    Student[] table;
    int count;  // number of Students in the table
    
    public Hashtable() {
        table = new Student[TABLE_SZ];
        count = 0;
    }
    

    
    /* MethodName: insertCollisions
     * Purpose: insert s into this Hashtable with no collision handling strategy
     * Parameters: Student - s
     * Throws:  TableFullException - if inserting into a full table
     *          CollisionException - if inserting a new key into table at index that is full
     * Returns: nothing
     */
	public void insertCollisions(Student s) throws TableFullException, CollisionException {
		int hashcode = s.hashCode();
        int ind = hashcode % table.length;
        
		if (count >= table.length) {
			throw new TableFullException();
        } else if (table[ind] == null) {
			table[ind] = s;
			count++;
        } else if (table[ind].getSID().compareTo(s.getSID()) == 0) {
			throw new CollisionException();
		}
	}
    
    /* MethodName: getCollisions
     * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
	public int getCollisions (String sid) throws KeyNotFoundException {
		int hashcode=sid.hashCode();
		int ind = hashcode % table.length;
		
		if (table[ind]==null || table[ind].getSID().compareTo(sid)!=0) {
			throw new KeyNotFoundException();
		}
		return table[ind].getGrade();
	}
    
    /* MethodName: insertLinearProbing
     * Purpose: insert s into this Hashtable with Linear Probing to handle collisions
     * Parameters: Student - s
     * Throws: TableFullException  - if inserting into a full table
     * Returns: nothing
     */
	public void insertLinearProbing(Student s) throws TableFullException{
		int hashcode = s.hashCode();
		int i = hashcode % table.length;
		
		if (count >= table.length) {
			throw new TableFullException();
		}
		if (table[i] == null) {
			table[i] = s;
			count++;
			return;
		}
		else if (table[i].equals(s)) {
			table[i] = s;	
			return;
		}
		int j = i;
		for (;i < table.length;i++) {
			if (table[i] == null) {
				table[i] = s;
				count++;
				return;
			}
			else if (table[i].equals(s)) {
				table[i] = s;
				return;
			}
		}
		for (int k = 0;k < j;k++) {
			if (table[k] == null) {
				table[k] = s;
				count++;
				return;
			}
			else if (table[k].equals(s)) {
				table[k] = s;
				return;
			}
		}
	}

    
    /* getLinearProbing
     * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
	public int getLinearProbing(String sid) throws KeyNotFoundException {
		int hashcode = sid.hashCode();
        int i = hashcode % table.length;
		int j = i;
		for (;i<table.length;i++) {
			if (table[i]==null) {
				continue;
			}
			if (table[i].getSID().compareTo(sid) == 0) {
				return table[i].getGrade();
			}
		}
		for (int k = 0;k < j;k++) {
			if (table[k] == null) {
				continue;
			}
			if (table[k].getSID().compareTo(sid) == 0) {
				return table[k].getGrade();
			}
		}
		throw new KeyNotFoundException();
	}
    
    
    /*
     * Purpose: returns the number of elements in this Hashtable
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        return count;
    }
    
    /*
     * Purpose: returns a String reprensentation of elements
     *      in this Hashtable separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        String s = "";
        
        for(int i=0; i<TABLE_SZ; i++)
            if (table[i] != null)
                s  += table[i] + "\n";
        
        return s;
    }
    

}
