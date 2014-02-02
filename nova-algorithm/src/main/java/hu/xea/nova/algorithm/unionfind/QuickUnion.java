package hu.xea.nova.algorithm.unionfind;

/**
 * Uses the quick union algorithm to tell if two points (p, q) are 
 * connected to each other or not. 
 * 
 * @author xea
 *
 */
public class QuickUnion {

	private int id[];
	
	/**
	 * Initialize the id array with the length of n
	 */
	public QuickUnion(final int n) {
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * Determine the root element of node i
	 */
	private int root(final int i) {
		while (i != id[i]) {
			return root(id[i]);
		}
		
		return i;
	}
	
	/**
	 * Tells if node p and q are connected with each other
	 */
	public boolean connected(final int p, final int q) {
		final boolean connected = root(p) == root(q);
		
		return connected;
	}
	
	/**
	 * Connects the roots of the two nodes with a single step
	 */
	public void union(final int p, final int q) {
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
	}
}
