package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.UnlockAccountForm;
import com.ashokit.exception.UserAppException;
import com.ashokit.service.UserService;

@RestController
public class UnlockAccountRestController {

	@Autowired
	private UserService service;

	@PostMapping("/unlock")
	public String unlockUserAccount(@RequestBody UnlockAccountForm unlockAccForm) throws UserAppException {
		boolean status = service.unlockAccount(unlockAccForm);
		if (status) {
			return "Account unlocked successfully";
		} else {
			return "Incorrect Temporary Password";
		}
	}

}
