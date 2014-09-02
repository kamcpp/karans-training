
<%@page import="karans.s16.calculator.engine.OperationFactory"%>
<%@page import="karans.s16.calculator.engine.Operation"%>
<%@page import="karans.s16.calculator.Errors"%>
<%@page
	import="karans.s16.calculator.CalculationRequestValidatorFactory"%>
<%@page import="karans.s16.calculator.CalculationRequestValidator"%>
<%@page import="karans.s16.calculator.CalculationRequest"%>
<%
	String operand1 = request.getParameter("operand1");
	String operand2 = request.getParameter("operand2");
	String operation = request.getParameter("operation");

	CalculationRequest calculationRequest = new CalculationRequest();
	calculationRequest.setOperand1(operand1);
	calculationRequest.setOperand2(operand2);
	calculationRequest.setOperation(operation);

	Errors result = CalculationRequestValidatorFactory.create()
			.validate(calculationRequest);
	if (result.hasAnyErrors()) {
		// TODO
		response.sendRedirect("calculator.jsp?e=????");
	}

	double op1 = Double.parseDouble(operand1);
	double op2 = Double.parseDouble(operand2);
	Operation<Double, Double, Double> op = (Operation<Double, Double, Double>) OperationFactory
			.createFromString(operation);

	double finalResult = op.perform(op1, op2);

	response.sendRedirect("calculator.jsp?r=" + finalResult + "&a="
			+ operand1 + "&b=" + operand2);
%>