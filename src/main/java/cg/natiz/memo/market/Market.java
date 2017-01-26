package cg.natiz.memo.market;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Singleton;


@SuppressWarnings("serial")
@Singleton
public class Market implements Serializable {

	private final int DEFAULT_MARKET_SIZE = 20;
	private AtomicBoolean closed = new AtomicBoolean(false);
	private BlockingQueue<Product> queue = new ArrayBlockingQueue<Product>(
			DEFAULT_MARKET_SIZE);

	/**
	 * Sell or not a product within 200 ms
	 * 
	 * @param product
	 *            product to be sold
	 * @return true if the product have been sold
	 * @throws InterruptedException
	 */
	public boolean sell(Product product) throws InterruptedException {
		return queue.offer(product, 200, TimeUnit.MILLISECONDS);
	}

	/**
	 * Purchase or not a product within 200 ms
	 * 
	 * @return purchased product
	 * @throws InterruptedException
	 */
	public Product purchase() throws InterruptedException {
		return queue.poll(200, TimeUnit.MILLISECONDS);
	}

	public int getStock() {
		return queue.size();
	}

	public boolean close() {
		return this.closed.getAndSet(true);
	}

	public boolean isClosed() {
		return this.closed.get();
	}

	public boolean isSatured() {
		return getStock() >= DEFAULT_MARKET_SIZE;
	}
}