package com.cherrypicks.lib.ui.dialog;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.cherrypicks.lib.protocol.IDialogCallback;

/**
 * DialogManager, manage all the error,info and waiting dialog inside the app.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class DialogManager {

	public static void showErrorDialog(FragmentTransaction ft, Bundle bundle,
			IDialogCallback callback) {
		ErrorDialog dialog = ErrorDialog.newInstance(bundle);
		dialog.setResonse(callback);

		dialog.show(ft, "error");
	}

	public static void showAlertDialog(FragmentTransaction ft, Bundle bundle,
			IDialogCallback callback) {

	}

	public static void showWaitingDialog(FragmentTransaction ft, Bundle bundle,
			IDialogCallback callback) {

	}

}
