package com.cherrypicks.lib.ui.fragment;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cherrypicks.lib.R;

/**
 * TestLocationFragment, for demonstrating how to get current location by
 * extends {@link BaseLocationFragment}
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class TestLocationFragment extends BaseLocationFragment {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		initValues();
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
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
	}

	@Override
	public void findViews() {
		// Get handles to the UI view objects
	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub
		super.bindEvents();
	}

	@Override
	protected void locateUpdated(Location location) {
		// TODO Auto-generated method stub

		Toast.makeText(getActivity(),
				location.getLatitude() + "," + location.getLongitude(),
				Toast.LENGTH_LONG).show();
	}

	@Override
	protected void addressUpdated(String address) {
		// TODO Auto-generated method stub
		super.addressUpdated(address);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		main = inflater.inflate(R.layout.location_fragment, null);

		findViews();

		return main;
	}

}
