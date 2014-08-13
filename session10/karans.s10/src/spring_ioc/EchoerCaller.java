package spring_ioc;

import javax.annotation.Resource;

public class EchoerCaller {

	@Resource(name = "echoer2")
	private Echoer echoer;

	public Echoer getEchoer() {
		return echoer;
	}

	public void setEchoer(Echoer echoer) {
		this.echoer = echoer;
	}

	public void call() {
		echoer.echo();
	}
}
