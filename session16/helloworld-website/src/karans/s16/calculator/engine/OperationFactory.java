package karans.s16.calculator.engine;

public class OperationFactory {

	public static Operation<?, ?, ?> createFromString(String operationString) {
		switch (operationString) {
		case "add":
			return new AddOperation();
		case "multiply" :
			return new MultiplyOperation();
		default:
			throw new RuntimeException("Operation string is not supported.");
		}
	}
}
