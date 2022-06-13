package com.kdn.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<CustomErrorResponse> customHandle(ServiceException ex, HandlerMethod method,
			HttpServletRequest request) {

		CustomErrorResponse error = new CustomErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setError(ex.getMessage());
		error.setErrCode(ex.getErrCode());
		error.setUri(request.getRequestURI());
		error.setHttpStatus(ex.getHttpStatusCode().value());

		return new ResponseEntity<>(error, ex.getHttpStatusCode());
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorResponse error = new CustomErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setError(ex.getLocalizedMessage());
		error.setErrCode(ErrorCode.DATA_CONVERSION_ERROR);
		error.setUri(((ServletWebRequest)request).getRequest().getRequestURI());
		error.setHttpStatus(status.value());

		return handleExceptionInternal(ex, error, headers, status, request);
	}

}