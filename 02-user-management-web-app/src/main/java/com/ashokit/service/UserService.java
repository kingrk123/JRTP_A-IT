package com.ashokit.service;

import java.util.Map;

import com.ashokit.bindings.LoginForm;
import com.ashokit.bindings.UnlockAccountForm;
import com.ashokit.bindings.UserRegForm;
import com.ashokit.exception.UserAppException;

public interface UserService {

	public String loginCheck(LoginForm loginForm) throws UserAppException;

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public String emailCheck(String emailId);

	public boolean saveUser(UserRegForm userForm) throws UserAppException;

	public boolean unlockAccount(UnlockAccountForm unloackAccForm) throws UserAppException;

	public boolean forgotPwd(String emailId) throws UserAppException;

}
