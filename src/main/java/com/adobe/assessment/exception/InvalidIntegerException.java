package com.adobe.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="The integer number is out of range for this Roman number API")
public class InvalidIntegerException extends RuntimeException {}