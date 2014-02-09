package hu.xea.nova.algorithm.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightedQuickUnionTest {

	@Test
	public void calculatesCorrectly() {
		final WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		
		// 5-0 8-9 3-6 7-2 0-7 9-3 6-1 2-6 7-4 
		
		wqu.union(5, 0);
		assertEquals("5 1 2 3 4 5 6 7 8 9", wqu.toString());
		wqu.union(8, 9);
		wqu.union(3, 6);
		wqu.union(7, 2);
		wqu.union(0, 7);
		assertEquals("5 1 7 3 4 5 3 5 8 8", wqu.toString());
		wqu.union(9, 3);
		wqu.union(6, 1);
		wqu.union(2, 6);
		wqu.union(7, 4);
		assertEquals("5 8 7 8 8 8 3 5 8 8", wqu.toString());
		
	}
}
