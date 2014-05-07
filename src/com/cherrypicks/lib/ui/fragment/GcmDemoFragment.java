package com.cherrypicks.lib.ui.fragment;

import com.cherrypicks.lib.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * GcmDemoFragment, fragment for demonstrating gcm message push.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class GcmDemoFragment extends BaseFragment {

	private String message;

	private TextView txt_gcm_message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		initValues();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		main = inflater.inflate(R.layout.gcm_fragment, null);
		findViews();
		return main;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		bindEvents();
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		message = getArguments().getString("message");
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

		txt_gcm_message = (TextView) main.findViewById(R.id.txt_gcm_message);

	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub
		txt_gcm_message.setText(message);
	}

}
