package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterAspect {

	@After("execution(* *.*())")
	public void doSomething() {
		System.out.println("After calling echo ...");
	}
}
