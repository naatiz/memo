package cg.natiz.memo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * Concurrent thread access !
 *
 */
public class AtomicIntegerExample {

	public static void main(String[] args) throws Exception {
		final ExecutorService executor = Executors.newFixedThreadPool(2);

		AtomicInteger increment = new AtomicInteger(0);
		IntStream.range(0, 1000).forEach(i -> executor.submit(increment::incrementAndGet));

		AtomicInteger update = new AtomicInteger(0);
		IntStream.range(0, 1000).forEach(i -> {
			Runnable task = () -> update.updateAndGet(n -> n + 2);
			executor.submit(task);
		});

		AtomicInteger accumulate = new AtomicInteger(0);
		IntStream.range(0, 1000).forEach(i -> {
			Runnable task = () -> accumulate.accumulateAndGet(i, (n, m) -> n + m);
			executor.submit(task);
		});

		LongAdder adder = new LongAdder();
		IntStream.range(0, 1000).forEach(i -> executor.submit(adder::increment));
		
		LongBinaryOperator op = (x, y) -> 2 * x + y;
		LongAccumulator accumulator = new LongAccumulator(op, 1L);
		IntStream.range(0, 10)
	    .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

		executor.awaitTermination(2L, TimeUnit.SECONDS);
		executor.shutdown();

		System.out.println("increment : " + increment.get()); // => 1000
		System.out.println("update : " + update.get()); // => 2000
		System.out.println("accumulate : " + accumulate.get()); // => 499500
		System.out.println("adder : " + adder.sumThenReset()); // => 1000
	    System.out.println("accumulator : " + accumulator.getThenReset());     // => 2539 ? (2037 OK)

	}
}
