package com.example.restApi.converters;

public class NumberConverter {
	
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", "."); //-> converte toda virula que for inserida para um ponto;
		if (IsNumeric(number)) return Double.parseDouble(number);
		return null;
	}

	public static boolean IsNumeric(String strNumeric) {
		if (strNumeric == null) return false;
		String number = strNumeric.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
	


}
