package hu.xea.nova.algorithm.unionfind;

/**
 * Uses the weighted quick union algorithm to tell if two points (p, q) are 
 * connected to each other or not.
 * 
 * It is different from the quick union in that it pays attention to the size
 * of the trees so they don't get too tall and difficult to traverse.
 * 
 * @author xea
 *
 */
public class WeightedQuickUnion {

	/**
	 * the array containing the parent id's of the points
	 */
	private int id[];
	
	/**
	 * The array containing the height of the trees containing the point
	 */
	private int size[];
	
	/**
	 * Initialize the id array with the length of n
	 */
	public WeightedQuickUnion(final int n) {
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
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
	 * Connects the roots of the two nodes with a single step. The sizes of the trees
	 * get updated too.	
	 */
	public void union(final int p, final int q) {
		int i = root(p);
		int j = root(q);
		
		if (i != j) {
			if (size[i] < size[j]) {
				id[i] = j;
				size[j] += size[i];
			} else {
				id[j] = i;
				size[i] += size[j];
			}
		}
		
	}
}
