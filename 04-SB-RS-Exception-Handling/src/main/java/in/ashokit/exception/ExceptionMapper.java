package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<String> handleArithmeticException(ArithmeticException ae) {
		System.out.println("****handleArithmeticException() method called*****");
		return new ResponseEntity<>(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException ndfe) {
		System.out.println("*****handleNoDataFoundException() method called*****");

		ErrorResponse response = new ErrorResponse();
		response.setErrorCode("ERR102");
		response.setErrorMsg(ndfe.getMessage());
		response.setErrorDateTime(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
