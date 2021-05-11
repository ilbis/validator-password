package com.itau.validatorpassword.service.impl;

import org.springframework.stereotype.Component;

import com.itau.validatorpassword.service.ValidatorPasswordService;

@Component(value = "validatorPasswordService")
public class ValidatorPasswordServiceImpl implements ValidatorPasswordService {

	@Override
	public boolean validatePassword(String password) {
		return (!password.isEmpty() && validateQuantityChar(password, 9) && validateContainsNumber(password) && validateLowerCase(password)
				&& validateUpperCase(password) && validateSpecialChar(password) && validateRepeatedChar(password));
	}

	@Override
	public boolean validateQuantityChar(String password, int qtdMin) {
		return (password.length() >= qtdMin);
	}

	@Override
	public boolean validateContainsNumber(String password) {
		return password.matches(".*[0-9].*");
	}

	@Override
	public boolean validateLowerCase(String password) {
		return password.matches(".*[a-z].*");
	}

	@Override
	public boolean validateUpperCase(String password) {
		return password.matches(".*[A-Z].*");
	}

	@Override
	public boolean validateSpecialChar(String password) {
		return password.matches(".*[!@#$%^&*()+-].*");
	}

	@Override
	public boolean validateRepeatedChar(String password) {
		for (int letter1 = 0; letter1 < password.length(); letter1++) {
			for (int letter2 = letter1 + 1; letter2 < password.length(); letter2++) {
				if (password.charAt(letter1) == password.charAt(letter2)) {
					return false;
				}
			}
		}
		return true;
	}
}
