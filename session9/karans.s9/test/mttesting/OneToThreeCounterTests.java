package mttesting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OneToThreeCounterTests {

	private MyInteger counter = new MyInteger(0);

	@Test
	public void testThreeThreadsFinished() {

		class TestNumberPrinterRunnable extends NumberPrinterRunnable {

			@Override
			protected void after() {
				synchronized (counter) {
					counter.increase();
					counter.notifyAll();
				}
			}
		}

		class TestOneToThreeCounter extends OneToThreeCounter {

			private List<Thread> threads = new ArrayList<Thread>();

			public TestOneToThreeCounter(Class<?> clazz, int n) {
				super(clazz, n);
			}

			protected void createRunnables() throws InstantiationException,
					IllegalAccessException {
				for (int i = 1; i <= n; i++) {
					NumberRunnable r = new TestNumberPrinterRunnable();
					r.setNumber(i);
					runnables.add(r);
				}
			}

			protected Thread createThread(int i) throws InstantiationException,
					IllegalAccessException {
				Thread t = super.createThread(i);
				threads.add(t);
				return t;
			}

			public void waitForThreads() {
				for (Thread t : threads) {
					try {
						t.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		TestOneToThreeCounter c = new TestOneToThreeCounter(
				TestNumberPrinterRunnable.class, 3);
		c.count();
		c.waitForThreads();

		Assert.assertEquals((long) 3, (long) counter.intValue());
	}
}
