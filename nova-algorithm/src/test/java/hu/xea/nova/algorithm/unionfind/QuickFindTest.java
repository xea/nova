package hu.xea.nova.algorithm.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickFindTest {

	@Test
	public void calculatesCorrectly() {
		final QuickFind qf = new QuickFind(10);
		
		assertEquals("0 1 2 3 4 5 6 7 8 9", qf.toString());
		
		qf.union(5, 7);
		assertEquals("0 1 2 3 4 7 6 7 8 9", qf.toString());
		
		qf.union(8, 7);
		qf.union(0, 9);
		qf.union(8, 0);
		qf.union(6, 9);
		assertEquals("9 1 2 3 4 9 9 9 9 9", qf.toString());
		
		qf.union(2, 1);
		assertEquals("9 1 1 3 4 9 9 9 9 9", qf.toString());
	}
}
