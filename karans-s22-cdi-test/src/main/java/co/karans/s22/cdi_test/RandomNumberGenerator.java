package co.karans.s22.cdi_test;

import java.util.Random;

@co.karans.s22.cdi_test.qualifiers.Random
public class RandomNumberGenerator implements  NumberGenerator {

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
