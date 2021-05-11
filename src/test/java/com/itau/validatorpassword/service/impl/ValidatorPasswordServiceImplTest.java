package com.itau.validatorpassword.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Testes unitarios dos metodos do ValidatorPasswordServiceImpl
 */

public class ValidatorPasswordServiceImplTest {

	ValidatorPasswordServiceImpl validatorPasswordService = new ValidatorPasswordServiceImpl();

	static final String PASSWORDVALID = "AbTp1!fok";

	@Test
	public void validatePasswordTest() {
		String passwordInvalid = "";

		assertEquals(true, validatorPasswordService.validatePassword(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validatePassword(passwordInvalid));
	}

	@Test
	public void validateQuantityCharTest() {
		String passwordInvalid = "AbT";

		assertEquals(true, validatorPasswordService.validateQuantityChar(PASSWORDVALID, 9));
		assertEquals(false, validatorPasswordService.validateQuantityChar(passwordInvalid, 9));
	}

	@Test
	public void validateContainsNumberTest() {
		String passwordInvalid = "AbTp!fok";

		assertEquals(true, validatorPasswordService.validateContainsNumber(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validateContainsNumber(passwordInvalid));
	}

	@Test
	public void validateLowerCaseTest() {
		String passwordInvalid = "AT1!";

		assertEquals(true, validatorPasswordService.validateLowerCase(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validateLowerCase(passwordInvalid));
	}

	@Test
	public void validateUpperCaseTest() {
		String passwordInvalid = "bp1!fok";

		assertEquals(true, validatorPasswordService.validateUpperCase(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validateUpperCase(passwordInvalid));
	}

	@Test
	public void validateSpecialCharTest() {
		String passwordInvalid = "AbTp1fok";

		assertEquals(true, validatorPasswordService.validateSpecialChar(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validateSpecialChar(passwordInvalid));
	}

	@Test
	public void validateRepeatedCharTest() {
		String passwordInvalid = "AbTp1fokA";

		assertEquals(true, validatorPasswordService.validateRepeatedChar(PASSWORDVALID));
		assertEquals(false, validatorPasswordService.validateRepeatedChar(passwordInvalid));
	}

}
