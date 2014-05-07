package com.cherrypicks.lib.protocol;

/**
 * The callback interface we used through out the entire application.
 * When some method is run in asynchronous way and return values are expected, it should accept the Callback objects as parameters.
 * In such way, the asynchronous method can "return" something to the caller after the execution is finished.
 *
 * @param <T> Expected response type
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public interface Callback<T> {
	
	void execute(final T response);
}
