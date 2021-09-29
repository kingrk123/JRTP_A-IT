package in.ashokit.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String errorCode;
	private String errorMsg;
	private LocalDateTime errorDateTime;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public LocalDateTime getErrorDateTime() {
		return errorDateTime;
	}

	public void setErrorDateTime(LocalDateTime errorDateTime) {
		this.errorDateTime = errorDateTime;
	}

}
