package co.karans.session27.servicescalc;

import javax.jws.WebService;
import java.util.Random;

@WebService
public class CalcService {

    public double add(double a, double b) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("CALC SERVICE FAILED.");
        }
        return a + b;
    }
}
