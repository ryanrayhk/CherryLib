package com.cherrypicks.lib.error;

/**
 * An error class representing any problems during the  http request
 * process.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class HttpError extends GeneralError {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8263534486684831862L;
	public static final int CODE = 201;

	public HttpError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

	public HttpError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public HttpError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int getCode() {
		// TODO Auto-generated method stub
		return CODE;
	}

}
