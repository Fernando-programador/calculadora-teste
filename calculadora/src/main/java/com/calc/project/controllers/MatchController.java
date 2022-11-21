package com.calc.project.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.calc.project.exception.UnsuportMathOperationException;

@RestController
public class MatchController {
	
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationException("Please set a numeric value!");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	
		
		
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		//transformar Br10,25 em Us10.25
		String number  = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number  = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
	

}
