package cg.natiz.memo.market;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;


public class Purchaser implements Callable<String> {
	@Inject
	private Market market;

	@Inject
	private Logger logger;

	public String call() throws Exception {
		while (!market.isClosed() || market.isClosed()
				&& market.getStock() != 0) {
			Thread.sleep(1000);
			Product product = market.purchase();
			logger.log(Level.INFO, Thread.currentThread().getName()
					+ " : Purchased " + product);
			logger.log(Level.INFO, Thread.currentThread().getName()
					+ " : remained stock = " + market.getStock());
		}
		return "sucess";
	}
}
