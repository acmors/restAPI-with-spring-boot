package com.example.restApi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	private static AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception 
	{
		if (!IsNumeric(numberOne) || !IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!IsNumeric(numberOne) || !IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!IsNumeric(numberOne) || !IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double Division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!IsNumeric(numberOne) || !IsNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/avarege/{numbers}", method = RequestMethod.GET)
	public Double Avarege(@PathVariable(value = "numbers") String numbers) {
		
		String[] numberArr = numbers.split(",");
		Double sum = 0.0;
		Integer count = 0;
		
		for (String number : numberArr) {
			
			if (!IsNumeric(number)){
				throw new UnsupportedMathOperationException("set a numeric value");
			}
			sum += convertToDouble(number);
			count++;
		}
		
		return sum / count;
	}
	
	@RequestMapping(value = "/square_root/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) {
		if (!IsNumeric(numberOne)){
			throw new UnsupportedMathOperationException("set a numeric value");
		}
		return Math.sqrt(convertToDouble(numberOne));
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", "."); //-> converte toda virula que for inserida para um ponto;
		if (IsNumeric(number)) return Double.parseDouble(number);
		return null;
	}

	private boolean IsNumeric(String strNumeric) {
		if (strNumeric == null) return false;
		String number = strNumeric.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
}
