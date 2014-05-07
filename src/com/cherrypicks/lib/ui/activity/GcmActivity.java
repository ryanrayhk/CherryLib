package com.cherrypicks.lib.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.ui.fragment.GcmDemoFragment;
import com.cherrypicks.lib.utils.Logger;

public class GcmActivity extends BaseActivity {

	private Bundle bundle;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.gcm_activity);

		initValues();

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		GcmDemoFragment gcmFragment = new GcmDemoFragment();
		gcmFragment.setArguments(bundle);
		ft.add(R.id.layout_container, new GcmDemoFragment());
		ft.commit();
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		logger = Logger.Jlog();
		bundle = new Bundle();

		Intent intent = getIntent();
		bundle.putString("message", intent.getStringExtra("message"));
	}

}
