// Sumeir Khinda, V00933760
// I took this course in Spring 2020 as well, and this assignment is the exact same as one of the older assignments. If there is any similarity between 
// my implementations, it is purely due to me thinking about the solution the same way this time (which is very likely to happen), not copying from my earlier work. 

import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		try {
			bst.find(key);
		} catch (KeyNotFoundException e) {
			return false;
		}
		return true;
	}

	public V get (K key) throws KeyNotFoundException {
		return bst.find(key);
	}

	public List<Entry<K,V> >	entryList() {
		return bst.entryList();
	}

	public void put (K key, V value) {
		bst.insert(key,value);
	}

	public int size() {
		return bst.size();
	}

	public void clear() {
		bst.clear();
	}

}