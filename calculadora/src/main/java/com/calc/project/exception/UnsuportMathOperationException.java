package com.calc.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportMathOperationException extends RuntimeException{


	





	public UnsuportMathOperationException(String ex) {
		super(ex);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	
	
}
