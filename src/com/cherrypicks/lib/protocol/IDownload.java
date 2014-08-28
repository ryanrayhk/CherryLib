package com.cherrypicks.lib.protocol;

public interface IDownload {

	/**
	 * Do something before download begin.
	 */
	void onStart();

	/**
	 * Notify the download progress.
	 */
	void onProgress();

	/**
	 * Do something after downloading completed.
	 */
	void onFinish();

	/**
	 * Error happened.
	 */
	void onError(Exception e);

}
