package cg.natiz.memo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Concurrent thread access !
 *
 */
public class ThreadingExample {

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		}); // => Hello pool-1-thread-1

		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Task interrupted", e);
			}
		};

		Future<Integer> future = executor.submit(task);
		System.out.println("Future done : " + future.isDone());
		Integer result = future.get();
		System.out.println("Future done : " + future.isDone());
		System.out.println("Result : " + result);

		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

		Runnable atask = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> afuture = scheduledExecutor.schedule(atask, 3, TimeUnit.SECONDS);

		TimeUnit.MILLISECONDS.sleep(1337);

		long remainingDelay = afuture.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms \n", remainingDelay);

		Runnable fixedRateTask = () -> System.out.println("Scheduling: " + System.nanoTime());

		int initialDelay = 0;
		int period = 1;
		scheduledExecutor.scheduleAtFixedRate(fixedRateTask, initialDelay, period, TimeUnit.SECONDS);

		Runnable fixeddelaytask = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: " + System.nanoTime());
			} catch (InterruptedException e) {
				System.err.println("Task interrupted");
			}
		};

		scheduledExecutor.scheduleWithFixedDelay(fixeddelaytask, 0, 1, TimeUnit.SECONDS);

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);

			scheduledExecutor.shutdown();
			scheduledExecutor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("executor: cancel non-finished tasks");
			}
			if (!scheduledExecutor.isTerminated()) {
				System.err.println("scheduledExecutor: cancel non-finished tasks");
			}
			scheduledExecutor.shutdownNow();
			scheduledExecutor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}
}
