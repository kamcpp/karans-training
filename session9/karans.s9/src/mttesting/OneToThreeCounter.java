package mttesting;

import java.util.ArrayList;
import java.util.List;

public class OneToThreeCounter {

	protected int n;
	private Class<?> clazz;
	protected List<Runnable> runnables = new ArrayList<Runnable>();

	public OneToThreeCounter(Class<?> clazz, int n) {
		this.clazz = clazz;
	}

	protected void createRunnables() throws InstantiationException,
			IllegalAccessException {
		for (int i = 1; i <= n; i++) {
			NumberRunnable r = (NumberRunnable) clazz.newInstance();
			r.setNumber(i);
			runnables.add(r);
		}
	}

	protected Thread createThread(int i) throws InstantiationException,
			IllegalAccessException {
		Thread t = new Thread(runnables.get(i - 1));
		return t;
	}

	public void count() {
		try {
			createRunnables();
			for (int i = 1; i <= n - 1; i++) {
				Thread t = createThread(i);
				t.start();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
