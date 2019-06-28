package com.woongjin.springsi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=WoongjinException.class)
	public Map<String, Object> handleWoongjinException(WoongjinException e) {
		
		String errorCode = e.getMessage();
		
//		ErrorCodeProcessor p = new ErrorCodeProcessor(errorCode);
//		p.getSolution();
//		
		Map<String, Object> result = new HashMap<>();
		result.put("error_code", e.getMessage());
		
		return result;
	}
	
	@ExceptionHandler(value=BadSqlGrammarException.class)
	public Map<String, Object> handleBadSQLGrammarException(BadSqlGrammarException e) {
		Map<String, Object> result = new HashMap<>();
		result.put("error_msg", e.getMessage());
		result.put("error_root", e.getRootCause());
		return result;
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public Map<String, Object> handleArithmaticException(ArithmeticException e) {
		Map<String, Object> result = new HashMap<>();
		result.put("error_msg", e.getMessage());
		result.put("message", "0으로 나누시면 안되요..");
		return result;
	}
	
	@ExceptionHandler(value=Throwable.class)
	public Map<String, Object> handleException(Throwable e) {
		Map<String, Object> result = new HashMap<>();
		result.put("error_msg", e.getMessage());
		result.put("message", "알수없는 새로운 예외 ");
		return result;
	}

}




