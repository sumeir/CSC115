/*
	name: Sumeir Khinda
	V#: V00933760
	NOTE: I took this course in Spring 2020 as well, and this assignment is the exact same as one of the older assignments. If there is any similarity between 
	my implementations, it is purely due to me thinking about the solution the same way this time (which is very likely to happen), not copying from my earlier work. 
*/

import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private long getLoops;
	private long putLoops;
	private int  tableSize;

	private List<List<Entry<K,V>>> 	table;
	private int	count;

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}
		
		count = 0;

		resetGetLoops();
		resetPutLoops();
	}

	public long getGetLoopCount() {
		return getLoops;
	}

	public long getPutLoopCount() {
		return putLoops;
	}

	public void resetGetLoops() {
		getLoops = 0;
	}
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		// iterator for the linked list at index found using the hash fn
		Iterator<Entry<K,V>> iter = table.get(index).iterator();

		while (iter.hasNext()) {
			Entry<K,V> e = iter.next();
			if (e.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		Iterator<Entry<K,V>> iter = table.get(index).iterator();

		while (iter.hasNext()) {
			Entry<K,V> e = iter.next();
			if (e.getKey().equals(key)) {
				return e.getValue();
			}
		}

		throw new KeyNotFoundException();
	}

	public List<Entry<K,V> > entryList() {
		List <Entry<K,V>> l = new LinkedList<Entry<K,V>>();
		Iterator <List<Entry<K,V>>> arrayIter = table.iterator();

		while (arrayIter.hasNext()) {
			Iterator<Entry<K,V>> llIter = arrayIter.next().iterator();
			while (llIter.hasNext()) {
				Entry<K,V> e = llIter.next();
				l.add(e);
			}
		}
		return l;
	}

	public void put (K key, V value) {
        int index = Math.abs(key.hashCode())%tableSize;
        Iterator<Entry<K, V>> iter = table.get(index).iterator();

			while (iter.hasNext()) {
			  Entry<K,V> e = iter.next();
			   if (e.getKey().equals(key)) {
					e.setValue(value);
					return;
			   }
			}

			table.get(index).add(new Entry<K, V>(key,value));
			count++;
    }

	public int size() {
		return count;
	}

	public void clear() {
		table.clear();
		count = 0;
	}

}
