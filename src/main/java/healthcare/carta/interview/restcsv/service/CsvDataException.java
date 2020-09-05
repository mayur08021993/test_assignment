package healthcare.carta.interview.restcsv.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class CsvDataException extends Exception {

	private String errMsg;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CsvDataException() {
	}
	
	public CsvDataException(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
		
	
}
