package cg.natiz.memo.market;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.StartMain;
import org.junit.Test;

public class MarketRunnerTest {
	
	@Test
	public void execute() {
		StartMain.main(new String[] {"MarketRunner", "param2", "param3", "param4"});
		assertTrue(true);
	}
}