package cg.natiz.memo.market;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;


public class Seller implements Callable<String> {

	private final Random rand = new Random();

	@Inject
	private Market market;

	@Inject
	private Logger logger;

	public String call() throws Exception {

		while (!market.isClosed()) {
			Thread.sleep(rand.nextInt(800));
			if (market.sell(new Product())) {
				logger.log(Level.INFO, Thread.currentThread().getName()
						+ " : stock = " + market.getStock());
			} else if (market.isSatured()) {
				logger.log(Level.INFO, Thread.currentThread().getName()
						+ " : Full stock = " + market.getStock());
				logger.log(Level.INFO, Thread.currentThread().getName()
						+ " : Market has been closed ");
				market.close();
			}
		}
		return "success";
	}
}
