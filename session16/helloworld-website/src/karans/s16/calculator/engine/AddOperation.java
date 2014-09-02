package karans.s16.calculator.engine;

public class AddOperation implements Operation<Double, Double, Double> {

	@Override
	public Double perform(Double a, Double b) {
		double result = a + b;
		return result;
	}
}
