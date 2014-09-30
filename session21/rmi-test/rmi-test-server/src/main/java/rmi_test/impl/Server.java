package rmi_test.impl;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        Naming.bind("//0.0.0.0:1099/myHelloWorldObject", new HelloWorldImpl());
        System.out.println("Object is bound.");
    }
}
