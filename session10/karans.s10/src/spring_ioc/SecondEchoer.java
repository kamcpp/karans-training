package spring_ioc;

public class SecondEchoer implements Echoer {

	@Override
	public void echo() {
		System.out.println("I'm the second!");
	}
	
	public void printName() {
		System.out.println("NAAAAME");
	}
}
