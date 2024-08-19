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
