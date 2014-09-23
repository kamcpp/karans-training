package karans.dummy;

public class SecondHelloEchoer implements  HelloEchoer{
    @Override
    public String echoHello() {
        return "Hello from Second impl.";
    }
}
