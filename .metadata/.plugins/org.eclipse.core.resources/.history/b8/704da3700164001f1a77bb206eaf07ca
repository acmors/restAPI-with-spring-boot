package com.example.restApi.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.converters.NumberConverter;
import com.example.restApi.exceptions.UnsupportedMathOperationException;
import com.example.restApi.math.SimpleMath;

@RestController
public class MathController {
	private static AtomicLong counter = new AtomicLong();
	
	private SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception 
	{
		if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return simpleMath.minus(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double Division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return simpleMath.Division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/avarege/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double Avarege(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
	
		return simpleMath.Avarege(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/square_root/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "number") String number) {
		if (!NumberConverter.IsNumeric(number)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return simpleMath.squareRoot(NumberConverter.convertToDouble(number));
	}

	
}
