package hu.xea.nova.algorithm.unionfind;

/**
 * Uses the Quick-find algorithm to tell if two points (p, q) are connected
 * with each other.
 * 
 * @author xea
 *
 */
public class QuickFind {

	/**
	 * Here we store the component id-s of each node.
	 * If two id's match then they are in the same group
	 */
	private int id[];
	
	/**
	 * We initialize the id array with a length of n
	 * @param n the number of nodes
	 * 
	 */
	public QuickFind(final int n) {
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * If the id-s of two nodes match then they are in the same component
	 * so they are connected.
	 */
	public boolean connected(final int p, final int q) {
		final boolean connected = id[p] == id[q];
		
		return connected;
	}
	
	/**
	 * With each union we have to update the id's for every node in that
	 * component where q is located at.
	 * 
	 * This is the weak spot of the algorithm, because this can be very
	 * expensive at large data sets.
	 * 
	 */
	public void union(final int p, final int q) {
		final int pid = id[p];
		final int qid = id[q];
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			} 
		}
	}
	
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		
		for (final int p : id) {
			sb.append(p + " ");
		}
		
		return sb.toString().trim();
	}
}

