package rmi_test.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote {

    HelloMessage sayHello(String name) throws RemoteException;

    void increaseCounter() throws RemoteException;

    int getCounter() throws RemoteException;
}
