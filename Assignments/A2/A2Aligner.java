// Name: Sumeir Khinda
// V#: V00933760

public class A2Aligner implements Aligner {
	private String sequence;
	private String lastTested;
	private int numErrors;
	private int offset;
	
	public A2Aligner(String sequence) {
		this.sequence = sequence;
		lastTested = "";
		offset = -1;
		numErrors = -1;
	}

	public String getSequence () {
		return sequence;
	}

	public String getLastTested () {
		return lastTested;
	}

	public int getNumErrors () {
		return numErrors;
	}

	public int getOffset () {
		return offset;
	}
		
	public int errorsAtOffset(int index, String subsequence) {
		int ctr = 0;

		char[] dataSequence = sequence.toCharArray();
		char[] toFind = subsequence.toCharArray();

		if (index+toFind.length<=dataSequence.length) {
			for (int i=index, j=0; j<toFind.length; i++, j++) {
				if (toFind[j]!=dataSequence[i]) {
					ctr++;
				}
			}
		} else {
			int k=index;
			int l=0;
			while (k!=dataSequence.length) {
				if (dataSequence[k]!=toFind[l]){
					ctr++;
				}
				k++;
				l++;
			}
			ctr += toFind.length - (dataSequence.length - index);
		}
		return ctr;
	}

	public void bestAlignmentOffset(String subsequence) {
		lastTested = subsequence;
		// ok, one thing out of the way.

		char[] dataSequence = sequence.toCharArray();

		// temporarily setting numErrors to errors at offset 0.
		numErrors= errorsAtOffset(0, subsequence);

		// using a new variable, to be used later to compare number of errors when looping thru the sequence
		int cur = numErrors;
		offset = 0;

		// looping through the sequence, checking for the least number of errors and setting that
		// equal to numErrors, and the offset to the index where there's least number of errors
		for(int i = 1; i<dataSequence.length; i++){
			cur = errorsAtOffset(i, subsequence);
			if (cur < numErrors) {
				numErrors = cur;
				offset = i;
			}
		}
	}	
	

	
	public String toString() {
		String s = 	"Data sequence: " + sequence + "\n";
		s +=		"Compared with: " + lastTested + "\n";
		s +=		"Best offset: "+ offset + "\n";
		s +=		"Errors detected: " + numErrors + "\n";
		return s;
	}
}