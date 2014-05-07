package com.cherrypicks.lib.ui.dialog;

import com.cherrypicks.lib.protocol.IDialogCallback;

import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * BaseDialogFragment, all the dialogFragment in this app should extends it.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public abstract class BaseDialogFragment extends DialogFragment {

	protected View main;
	protected IDialogCallback callback;

	/**
	 * Initialize values, it should be called before inflating layout.
	 */
	public abstract void initValues();

	/**
	 * Bind the widget of the layout file to the variable inside the fragment.
	 */
	public abstract void findViews();

	/**
	 * Add event to the widget.
	 */
	public abstract void bindEvents();

	/**
	 * Set callback to the dialog.
	 * @param callback
	 */
	protected void setResonse(IDialogCallback callback) {
		this.callback = callback;
	}
}
