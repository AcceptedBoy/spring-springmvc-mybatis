package com.acceptedboy.web.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acceptedboy.domain.model.ErrorInfo;
import com.acceptedboy.domain.model.ResponseMessage;

@ControllerAdvice
public class ExceptionHandleController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody ResponseEntity<ResponseMessage> handleBadRequest(HttpServletRequest request, 
			MissingServletRequestParameterException ex) {
		
	    return new ResponseEntity<>(ResponseMessage.addException(
	    		new ErrorInfo(request.getRequestURL().toString(), 
	    						overrideExceptionToString(ex.toString()), 
	    						HttpStatus.BAD_REQUEST.value(), 
	    						ex.getMessage())), 
	    		HttpStatus.BAD_REQUEST);
	}
	
	private String overrideExceptionToString(String toString) {
		return toString.substring(0, toString.indexOf(":"));
	}
}
