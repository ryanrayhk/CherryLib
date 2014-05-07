package com.cherrypicks.lib.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {

	private ThreadPoolUtil() {

	}

	private static class ThreadPoolUtilHolder {
		private static final ExecutorService instance = Executors
				.newCachedThreadPool();
	}

	public static ExecutorService getInstance() {
		return ThreadPoolUtilHolder.instance;
	}

}
