import services.Add;
import services.CalculatorService;

/**
 * Created by morteza on 11/5/14.
 */
public class TestClient {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.getCalculatorPort().add(4, 5);
        System.out.println(result);
    }
}
