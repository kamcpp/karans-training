package co.karans.session26.ejbs;

import java.util.concurrent.Future;

public interface FirstLocal {
    double calculate(double a, double b);

    Future<Double> calculateAsync(double a, double b);

    void generateRandomBook();
}
