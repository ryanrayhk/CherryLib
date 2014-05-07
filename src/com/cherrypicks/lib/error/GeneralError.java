package com.cherrypicks.lib.error;

/**
 * A generic error class to provide a standard error handling for the application.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public abstract class GeneralError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3906876687517571929L;

	/**
	 * Create an AbstractErrorCause instance.
	 * 
	 * @param message
	 *     		The error message
	 */
	public GeneralError(final String message) {
		super(message);
	}

	/**
	 * Create an AbstractErrorCause instance.
	 * 
	 * @param message
	 *            The error message
	 * @param cause
	 *            The error cause
	 */
	public GeneralError(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create an AbstractErrorCause instance.
	 * 
	 * @param cause
	 *            The error cause
	 */
	public GeneralError(final Throwable cause) {
		super(cause);
	}

	/**
	 * Get the error code.
	 * 
	 * @return The error code
	 */
	public abstract int getCode();
}
