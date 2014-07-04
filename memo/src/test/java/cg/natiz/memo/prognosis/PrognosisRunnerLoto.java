package cg.natiz.memo.prognosis;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import cg.natiz.memo.Config;
import cg.natiz.memo.prognosis.Event;
import cg.natiz.memo.prognosis.Generator;
import cg.natiz.memo.prognosis.Type;

public class PrognosisRunnerLoto {

	@Inject
	private Generator generator;

	@Inject
	private Logger logger;
	@Inject
	@Config(name = "Loto", length = 50, type = Type.LOTO)
	private Prognosis prognosis;

	public void execute(@Observes ContainerInitialized ci,
			@Parameters List<String> parameters) {
		if (!parameters.contains("PrognosisRunnerLoto"))
			return;
		Event pEvent = prognosis.getEvent();
		StringBuilder sb = new StringBuilder(pEvent.getName())
				.append(", ")
				.append(pEvent.getLength())
				.append(", ")
				.append(generator.generate(pEvent.getType().cardinal(),
						pEvent.getLength()));
		logger.log(Level.INFO, sb.toString());
	}
}