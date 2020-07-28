package com.ibm.cloud.academy.controller.bean;

public class Solution {

	private RandomInteger number1;
	private RandomInteger number2;
	private RandomOperator operator;

	private String expression;
	private String value;
	private String hostname;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public RandomInteger getNumber1() {
		return number1;
	}

	public void setNumber1(RandomInteger number1) {
		this.number1 = number1;
	}

	public RandomInteger getNumber2() {
		return number2;
	}

	public void setNumber2(RandomInteger number2) {
		this.number2 = number2;
	}

	public RandomOperator getOperator() {
		return operator;
	}

	public void setOperator(RandomOperator operator) {
		this.operator = operator;
	}
}
