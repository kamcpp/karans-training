package spring_ioc;

public class FirstEchoer implements Echoer {

	@Override
	public void echo() {
		System.out.println("I'm the first!");
	}

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		
	}
}
