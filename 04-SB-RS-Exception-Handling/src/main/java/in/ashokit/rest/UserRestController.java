package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<String> getName(@PathVariable Integer userId) throws Exception {
		String username = userService.getUsername(userId);
		return new ResponseEntity<>(username, HttpStatus.OK);
	}
}
