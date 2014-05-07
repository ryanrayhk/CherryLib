package com.cherrypicks.lib.protocol;

/**
 * DialogCallback help us handle event after we click button inside the dialog.
 * 
 * @since 1.1.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public interface IDialogCallback {

	void positive();

	void negative();

}
