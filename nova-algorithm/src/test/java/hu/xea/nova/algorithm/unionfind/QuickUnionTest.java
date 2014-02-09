package hu.xea.nova.algorithm.unionfind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickUnionTest {


	@Test
	public void noPointsShouldBeConnectedAfterInitialization() {
		final QuickUnion qu = new QuickUnion(10);
		
		assertFalse(qu.connected(0, 1));
		assertFalse(qu.connected(1, 2));
		assertFalse(qu.connected(2, 3));
	}
	
	@Test
	public void unionMethodConnectsPoints() {
		final QuickUnion qu = new QuickUnion(10);
		
		qu.union(3, 4);
		
		assertTrue(qu.connected(3,  4));
	}
	
	@Test
	public void rootsAreFoundOverLongerChains() {
		final QuickUnion qu = new QuickUnion(10);
		
		qu.union(3, 4);
		qu.union(4, 5);
		qu.union(5, 8);
		
		assertTrue(qu.connected(3, 8));
	}
	
}
