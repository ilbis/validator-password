package com.itau.validatorpassword.service;

/*
 * Declaração da interface
 */

public interface ValidatorPasswordService {

	boolean validatePassword(String password);

	boolean validateQuantityChar(String password, int qtdMin);

	boolean validateContainsNumber(String password);

	boolean validateLowerCase(String password);

	boolean validateUpperCase(String password);

	boolean validateSpecialChar(String password);

	boolean validateRepeatedChar(String password);
}
