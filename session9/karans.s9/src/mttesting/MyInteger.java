package mttesting;

public class MyInteger {

	private int n;

	public MyInteger(int n) {
		this.n = n;
	}

	public int intValue() {
		return n;
	}

	public void increase() {
		n++;
	}

	public void decrease() {
		n--;
	}
}
