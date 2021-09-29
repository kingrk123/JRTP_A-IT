package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@GetMapping("/test1")
	public String demo1() {
		String msg = null;
		int i = 10 / 0;
		msg = "Welcome to Ashok IT...!!";
		return msg;
	}
}
