package com.itau.validatorpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.validatorpassword.service.impl.ValidatorPasswordServiceImpl;

import io.swagger.annotations.Api;

/**
 * @author Ilbis Candido Silva 
 * Este controller é responsavel pela comunicação HTTP no contexto /validate
 */

@RestController
@RequestMapping("/validate")
@Api(value = "API for performing operations on Acronym")
public class ValidatorPasswordController {

	@Autowired
	ValidatorPasswordServiceImpl validatePassword;

	//Retorna true se passar por todas validações
	@PostMapping()
	public ResponseEntity<Boolean> validatePassword(@RequestBody(required = false) String password) {
		return ResponseEntity.ok().body(validatePassword.validatePassword(password));

	}

}
