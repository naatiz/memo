package cg.natiz.memo.market;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import cg.natiz.memo.market.Purchaser;
import cg.natiz.memo.market.Seller;

public class MarketRunner {

	@Inject
	private Logger logger;

	@Inject
	private Seller seller;

	@Inject
	private Purchaser purchaser;

	public void execute(@Observes ContainerInitialized event,
			@Parameters List<String> parameters) throws Exception {
		if (!parameters.contains("MarketRunner"))
			return;

		ExecutorService executor = Executors.newFixedThreadPool(10);
		Set<Callable<String>> workers = new HashSet<Callable<String>>(2);
		workers.add(seller);
		workers.add(purchaser);
		logger.info("Batch processes start running ... ");
		List<Future<String>> futures = executor.invokeAll(workers);
		for (Future<String> future : futures) {
			logger.info(future.get());
		}
		executor.shutdown();
		logger.info("Batch processes ended running ... ");
	}
}