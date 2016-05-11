package model;

public class Calculations {

	private double result;
	public String calculate(String num1, String operator, String num2) {
		switch (operator) {
		case "+":
			result = Double.parseDouble(num1) + Double.parseDouble(num2);
			break;
		case "-":
			result = Double.parseDouble(num1) - Double.parseDouble(num2);
			break;
		case "*":
			result = Double.parseDouble(num1) * Double.parseDouble(num2);
			break;
		case "/":
			if(Double.parseDouble(num2)==0)	result = 0;
			result = Double.parseDouble(num1) / Double.parseDouble(num2);
			break;
		}
		System.out.println(result);
		return String.valueOf(result);
	}
}
