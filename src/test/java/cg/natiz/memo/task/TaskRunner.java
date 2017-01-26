package cg.natiz.memo.task;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;


public class TaskRunner {

	@Inject
	private Logger logger;

	public void execute(@Observes ContainerInitialized event,
			@Parameters List<String> parameters) {
		if (!parameters.contains("TaskRunner"))
			return;
		// TODO Task batch
		StringBuilder sb = new StringBuilder("TODO");
		logger.log(Level.INFO, sb.toString());
	}
}