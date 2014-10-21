package co.karans.s22.cdi_test;

public class FirstHelloEchoer implements HelloEchoer {
    public FirstHelloEchoer() {
        System.out.println("First impl is being created.");
    }

    @Override
    public String sayHello() {
        return "First impl is saying hello.";
    }
}
