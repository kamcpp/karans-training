package ejb_test.method2;

import javax.ejb.Stateless;

@Stateless
public class NumberGeneratorEJB implements NumberGeneratorLocal {
    @Override
    public String generate() {
        return "12345";
    }
}
