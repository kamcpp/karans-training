package karans.s16.calculator;

public class CalculationRequestValidatorFactory {

	public static CalculationRequestValidator create() {
		return new DefaultCalculationRequestValidator();
	}
}
