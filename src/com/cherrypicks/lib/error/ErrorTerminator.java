package com.cherrypicks.lib.error;

import android.content.Context;
import android.os.Bundle;

import com.cherrypicks.lib.protocol.IDialogCallback;

public class ErrorTerminator {

	public static void handleError(Context context, GeneralError exception,
			IDialogCallback callback) {

		Bundle bundle = new Bundle();
		bundle.putString("message", exception.getMessage());

		switch (exception.getCode()) {
		case AuthorisationError.CODE:

			break;
		case HttpError.CODE:

			break;
		case JsonError.CODE:

			break;
		}

		if (callback != null) {
		}

	}

}
