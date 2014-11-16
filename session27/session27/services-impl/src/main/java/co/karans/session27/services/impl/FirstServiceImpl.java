package co.karans.session27.services.impl;

import co.karans.session26.ejbs.FirstLocal;
import co.karans.session27.services.FirstService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.concurrent.Future;

@WebService(endpointInterface = "co.karans.session27.services.FirstService")
public class FirstServiceImpl implements FirstService {

    @EJB
    private FirstLocal firstEJB;

    @Override
    public double calculate(double a, double b) {
        try {
            System.out.println("Invoking the method ...");
            return firstEJB.calculate(a, b);
        } finally {
            System.out.println("Result obtained.");
        }
    }

    @Override
    public double calculateMyAsync(double a, double b) {
        System.out.println("Invoking the method ...");
        Future<Double> future = firstEJB.calculateAsync(a, b);
        System.out.println("Method invoked.");
        try {
            System.out.println("Waiting for result ...");
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Result obtained.");
        }
    }
}
