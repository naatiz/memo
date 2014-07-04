package cg.natiz.memo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		
		final CountDownLatch latch = new CountDownLatch(3);

		//Waiter      waiter      = new Waiter(latch);
		//Decrementer decrementer = new Decrementer(latch);

		new Thread(new Runnable () {
		    public void run() {
		        try {
		            latch.await();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        System.out.println("Waiter Released");
		    }
		}).start();
		
		new Thread(new Runnable () {
		    public void run() {

		        try {
		            Thread.sleep(1000);
		            latch.countDown();

		            Thread.sleep(1000);
		            latch.countDown();

		            Thread.sleep(1000);
		            latch.countDown();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		}).start();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 1 executed ");
		    }
		};
		Runnable barrier2Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 2 executed ");
		    }
		};

		final CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		final CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);
		new Thread(new Runnable () {

		    public void run() {
		        try {
		            Thread.sleep(1000);
		            System.out.println(Thread.currentThread().getName() +
		                                " waiting at barrier 1");
		            barrier1.await();

		            Thread.sleep(1000);
		            System.out.println(Thread.currentThread().getName() +
		                                " waiting at barrier 2");
		            barrier2.await();

		            System.out.println(Thread.currentThread().getName() +
		                                " done!");

		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } catch (BrokenBarrierException e) {
		            e.printStackTrace();
		        }
		    }
		}).start();
		new Thread(new Runnable () {

		    public void run() {
		        try {
		            Thread.sleep(1000);
		            System.out.println(Thread.currentThread().getName() +
		                                " waiting at barrier 1");
		            barrier1.await();

		            Thread.sleep(1000);
		            System.out.println(Thread.currentThread().getName() +
		                                " waiting at barrier 2");
		            barrier2.await();

		            System.out.println(Thread.currentThread().getName() +
		                                " done!");

		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } catch (BrokenBarrierException e) {
		            e.printStackTrace();
		        }
		    }
		}).start();
	}
	
}
