package com.googlecode.richrest.util.validator;

public class EmailValidator extends PatternValidator {

	public EmailValidator() {
		super("^[\\-|_|0-9|a-z|A-Z]+\\@[\\-|_|0-9|a-z|A-Z]+\\.[a-z|A-Z][\\.|a-z|A-Z]*$");
	}

}