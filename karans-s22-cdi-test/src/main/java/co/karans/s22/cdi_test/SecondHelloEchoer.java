package co.karans.s22.cdi_test;

import javax.enterprise.inject.Alternative;

@Alternative
public class SecondHelloEchoer implements HelloEchoer {

    @Override
    public String sayHello() {
        return "Second impl is saying hello.";
    }
}
