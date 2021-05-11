package com.itau.validatorpassword.service.impl;

import org.springframework.stereotype.Component;

import com.itau.validatorpassword.service.ValidatorPasswordService;

@Component(value = "validatorPasswordService")
public class ValidatorPasswordServiceImpl implements ValidatorPasswordService {

	//Retorna true caso a senha seja validada por todas regras
	@Override
	public boolean validatePassword(String password) {
		return (password != null && !password.isEmpty() && validateQuantityChar(password, 9)
				&& validateContainsNumber(password) && validateLowerCase(password) && validateUpperCase(password)
				&& validateSpecialChar(password) && validateRepeatedChar(password));
	}

	//Valida quantidade minima de caracteres
	@Override
	public boolean validateQuantityChar(String password, int qtdMin) {
		return (password.length() >= qtdMin);
	}

	//Valida se contem algum numero
	@Override
	public boolean validateContainsNumber(String password) {
		return password.matches(".*[0-9].*");
	}

	//Valida se contem algum caracter minusculo
	@Override
	public boolean validateLowerCase(String password) {
		return password.matches(".*[a-z].*");
	}

	//Valida se contem algum caracter maiusculo
	@Override
	public boolean validateUpperCase(String password) {
		return password.matches(".*[A-Z].*");
	}

	//Valida se contem algum caracter especial
	@Override
	public boolean validateSpecialChar(String password) {
		return password.matches(".*[!@#$%^&*()+-].*");
	}

	//Valida se contem caracter repetido
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
