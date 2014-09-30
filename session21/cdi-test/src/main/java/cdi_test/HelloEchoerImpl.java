package cdi_test;

import javax.enterprise.inject.Alternative;

@Alternative
public class HelloEchoerImpl implements HelloEchoer {
    @Override
    public String echoHello() {
        return "HELLO WORLD !!!";
    }
}
