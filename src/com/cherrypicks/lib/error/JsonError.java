package com.cherrypicks.lib.error;

/**
 * An error class representing any problems during the json parse
 * process.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class JsonError extends GeneralError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640819062015731172L;
	public static final int CODE = 202;

	public JsonError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JsonError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCode() {
		// TODO Auto-generated method stub
		return CODE;
	}

}
