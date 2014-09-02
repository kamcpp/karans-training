package karans.s16.calculator.engine;

public class MultiplyOperation implements Operation<Double, Double, Double> {

	@Override
	public Double perform(Double a, Double b) {
		return a * b;
	}
}
