package ejb_test.method2;

import javax.ejb.Local;

@Local
public interface NumberGeneratorLocal {
    String generate();
}
