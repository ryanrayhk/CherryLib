package com.cherrypicks.lib.error;

/**
 * An error class representing any problems during the remote authorization
 * process.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class AuthorisationError extends GeneralError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5878880218568452307L;
	public static final int CODE = 203;

	public AuthorisationError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorisationError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthorisationError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCode() {
		// TODO Auto-generated method stub
		return CODE;
	}

}
