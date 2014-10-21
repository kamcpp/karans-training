package co.karans.s22.cdi_test;

import co.karans.s22.cdi_test.qualifiers.Sequential;

@Sequential
public class SequentialNumberGenerator implements  NumberGenerator {
    private int counter;

    public SequentialNumberGenerator() {
        this.counter = 0;
    }

    @Override
    public int generate() {
        return ++counter;
    }
}
