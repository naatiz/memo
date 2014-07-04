package cg.natiz.memo.prognosis;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.StartMain;
import org.junit.Test;

/**
 * @author natiz
 *
 */
public class PrognosisRunnerTest {

	@Test
	public void doublet() throws Exception {	
		StartMain.main(new String[] {"PrognosisRunnerDouble"});		
		assertTrue(true);
	}

	@Test
	public void tierce() throws Exception {	
		StartMain.main(new String[] {"PrognosisRunnerTierce"});	
		assertTrue(true);
	}

	@Test
	public void quinte() throws Exception {	
		StartMain.main(new String[] {"PrognosisRunnerQuinte"});	
		assertTrue(true);
	}

	@Test
	public void quintePlus() throws Exception {	
		StartMain.main(new String[] {"PrognosisRunnerQuintePlus"});	
		assertTrue(true);
	}

	@Test
	public void loto() throws Exception {	
		StartMain.main(new String[] {"PrognosisRunnerLoto"});	
		assertTrue(true);
	}
}