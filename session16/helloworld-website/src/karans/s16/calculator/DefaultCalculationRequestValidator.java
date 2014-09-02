package karans.s16.calculator;

public class DefaultCalculationRequestValidator implements
		CalculationRequestValidator {

	@Override
	public Errors validate(CalculationRequest request) {
		return new Errors();
	}
}
