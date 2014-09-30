package cdi_test;

import javax.enterprise.inject.Default;

@Default
public class HelloEchoerSecondImpl implements HelloEchoer {
    @Override
    public String echoHello() {
        return "SECOND HELLO !!!";
    }
}
