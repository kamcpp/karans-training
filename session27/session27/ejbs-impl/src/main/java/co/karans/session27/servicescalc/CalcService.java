package co.karans.session27.servicescalc;

import javax.jws.WebService;

@WebService
public interface CalcService {
    double add(double x, double y);
}
