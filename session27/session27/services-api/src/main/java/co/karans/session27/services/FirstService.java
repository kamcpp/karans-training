package co.karans.session27.services;

import javax.jws.WebService;

@WebService
public interface FirstService {

    double calculate(double a, double b);

    double calculateMyAsync(double a, double b);
}
