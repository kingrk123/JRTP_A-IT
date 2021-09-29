package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.main.CoGenDlyBatch;

@RestController
public class CoBatchTestRestController {

	@Autowired
	private CoGenDlyBatch coBatch;

	@GetMapping("/cobatch")
	public String invokeCoGenDlyBatch() {
		coBatch.start();

		return "Success";
	}

}
