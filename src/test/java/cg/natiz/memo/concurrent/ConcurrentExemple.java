package cg.natiz.memo.concurrent;

import cg.natiz.memo.concurrent.AtomicIntegerExample;
import cg.natiz.memo.concurrent.ConcurrentMapExample;
import cg.natiz.memo.concurrent.ThreadingExample;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ConcurrentExemple extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ConcurrentExemple(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ConcurrentExemple.class);
	}

	/**
	 * Rigourous AtomicInteger Test :-)
	 */
	public void testAtomicInteger() throws Exception {
		AtomicIntegerExample.main(new String[] { });
		assertTrue(true);
	}
	
	/**
	 * Rigourous ConcurrentMap Test :-)
	 */
	public void testConcurrentMap() throws Exception {
		ConcurrentMapExample.main(new String[] { });
		assertTrue(true);
	}
	
	/**
	 * Rigourous Threading Test :-)
	 */
	public void testThreading() throws Exception {
		ThreadingExample.main(new String[] { });
		assertTrue(true);
	}
}
