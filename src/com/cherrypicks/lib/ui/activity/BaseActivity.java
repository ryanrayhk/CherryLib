package com.cherrypicks.lib.ui.activity;

import android.support.v4.app.FragmentActivity;

import com.cherrypicks.lib.utils.Logger;

/**
 * BaseActivity, all the actvityies inside the app should extends it.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public abstract class BaseActivity extends FragmentActivity {

	protected Logger logger;

	public abstract void initValues();

}
