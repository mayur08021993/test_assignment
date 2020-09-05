package healthcare.carta.interview.restcsv.service;

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
