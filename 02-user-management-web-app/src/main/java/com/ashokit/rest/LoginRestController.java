package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.LoginForm;
import com.ashokit.exception.UserAppException;
import com.ashokit.service.UserService;

@RestController
public class LoginRestController {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) throws UserAppException{
		return service.loginCheck(loginForm);
	}
}
