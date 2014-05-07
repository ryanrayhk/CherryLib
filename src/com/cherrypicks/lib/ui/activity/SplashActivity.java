package com.cherrypicks.lib.ui.activity;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.ui.fragment.SplashDemoFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
/**
 * SplashActivity, do some initialization here.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.splash_activity);

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.layout_container, new SplashDemoFragment()).commit();

	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		
	}

}
