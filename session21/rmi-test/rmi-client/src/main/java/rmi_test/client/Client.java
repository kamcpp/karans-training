package rmi_test.client;


import rmi_test.api.HelloMessage;
import rmi_test.api.HelloWorld;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        HelloWorld remoteObject = (HelloWorld) Naming.lookup("rmi://10.10.103.29:1099/myHelloWorldObject");
        HelloMessage helloMessage = remoteObject.sayHello("Teacher");
        System.out.println(helloMessage.getMessage());
        for (int i = 1; i <= 5; i++) {
            remoteObject.increaseCounter();
            System.out.println(remoteObject.getCounter());
        }
    }
}
