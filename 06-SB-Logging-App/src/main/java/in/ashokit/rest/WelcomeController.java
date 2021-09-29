package in.ashokit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@GetMapping("/welcome")
	public String welcomeMsg() {

		logger.debug("welcomeMsg() execution started");

		try {
			int i = 10 / 0;
		} catch (Exception e) {
			logger.error("Exception Occured" + e.getMessage());
		}

		String msg = "Welcome to Ashok IT..!!";

		logger.debug("welcomeMsg() execution ended");

		logger.info("welcomeMsg() execution completed successfully");

		return msg;
	}
}
