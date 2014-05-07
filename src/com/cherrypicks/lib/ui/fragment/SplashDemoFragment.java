package com.cherrypicks.lib.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.ui.activity.MainActivity;
import com.cherrypicks.lib.utils.Logger;

/**
 * SplashFragment, do some initialization here.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class SplashDemoFragment extends BaseFragment {

	private TextView txt_cherrypicks_logo;
	private Animation anmi;

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
		main = inflater.inflate(R.layout.splash_fragment, null);

		findViews();

		return main;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		bindEvents();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		logger = Logger.Jlog();

		anmi = new AlphaAnimation(0.0f, 1.0f);
		anmi.setDuration(1000);
		anmi.setStartOffset(1000);
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

		txt_cherrypicks_logo = (TextView) main.findViewById(R.id.txt_logo);

	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub

		anmi.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				logger.d("Start");
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});

		txt_cherrypicks_logo.startAnimation(anmi);

	}

}
