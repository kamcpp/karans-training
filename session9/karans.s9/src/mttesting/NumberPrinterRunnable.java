package mttesting;

public class NumberPrinterRunnable implements NumberRunnable {

	private int number;

	@Override
	public void run() {
		try {
			System.out.println(number);
		} finally {
			after();
		}
	}

	protected void after() {
	}

	@Override
	public void setNumber(int n) {
		this.number = n;
	}
}
