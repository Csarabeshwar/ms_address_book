package com.reece.address.book.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reece.address.book.common.ApiError;
import com.reece.address.book.common.ApiErrorBuilder;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({})
	public ResponseEntity<ApiError> handleGeneralException(Exception exception, HttpServletRequest request) {
		ApiError apiError = ApiError.builder().errorId("ERR-500").httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(exception.getMessage()).build();
		return new ResponseEntity(ApiErrorBuilder.buildErrorResponse(apiError), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
