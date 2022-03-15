public class StackArrayBased implements Stack {
    private static final int INIT_SZ = 4;
    private char[] data;
    private int top;
    // NOTICE:  there is no count
    //  think about why you do not need a count given
    //  you are keeping track of the index of top
    

    public StackArrayBased() {
        data = new char[INIT_SZ];
        top = -1;
    }

    public int size() {
        return top==-1;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public void push(char val) {
        if (top < INIT_SZ-1) {
            top++;
            data[top] = val;
        } else {
        char[] temp = new char[data.length*2];
        for (int i=top; i>=0; i--) {
            temp[i]=data[i];
        }
        top++;
        temp[top] = val;
        data = temp;
        }
    }


    public char pop() {
        if (top == -1) {
            System.out.println("Empty");
            return 0;
        } else {
            char popVal = data[top];
            top--;
            return popVal;
        }
    }


    public char peek() {
        return data[top];
    }

	public void popAll(){
		for(int i = top; i >= 0; i--){
			pop();
		}
	}

    public void makeEmpty() {
        top = -1;
    }

    public String toString() {
        String result = "{";


        result += "}";
        return result;
    }
}

