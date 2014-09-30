package rmi_test.impl;

import rmi_test.api.HelloMessage;
import rmi_test.api.HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {

    private int counter;


    public HelloWorldImpl() throws RemoteException {
        counter = 0;
    }

    @Override
    public HelloMessage sayHello(String name) throws RemoteException {
        return new HelloMessage("Hello " + name + " from Karans over RMI");
    }

    @Override
    public void increaseCounter() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
