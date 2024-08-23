package com.example.restApi.math;


public class SimpleMath {

	
	public Double sum(Double numberOne, Double numberTwo) {
		
		return numberOne +numberTwo;
	}
	
	
	public Double minus(Double numberOne, Double numberTwo) {
	
		return numberOne - numberTwo;
	}
	

	public Double multiplication(Double numberOne, Double numberTwo) {

		return numberOne * numberTwo;
	}
	
	
	public Double Division(Double numberOne, Double numberTwo) {

		return numberOne / numberTwo;
	}
	

	public Double Avarege(Double numberOne, Double numberTwo) {
		
		return (numberOne + numberTwo) / 2;
	}
	

	public Double squareRoot(Double numberOne) {
		
		return Math.sqrt(numberOne);
	}

}
