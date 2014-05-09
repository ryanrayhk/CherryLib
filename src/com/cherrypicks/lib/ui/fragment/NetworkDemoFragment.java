package com.cherrypicks.lib.ui.fragment;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.error.ErrorTerminator;
import com.cherrypicks.lib.error.GeneralError;
import com.cherrypicks.lib.model.Member;
import com.cherrypicks.lib.network.NetworkManager;
import com.cherrypicks.lib.protocol.Callback;
import com.cherrypicks.lib.protocol.IDialogCallback;
import com.cherrypicks.lib.utils.CherryConfig;
import com.cherrypicks.lib.utils.Logger;
import com.loopj.android.http.RequestParams;

/**
 * NetworkDemoFragment, fragment for demonstrating the http network request
 * usage.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class NetworkDemoFragment extends BaseFragment {

	private TextView txt_member;
	private List<Member> memberList = null;
	private NetworkManager manager;

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
		main = inflater.inflate(R.layout.network_fragment, null);

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
		logger = Logger.Jlog();
		manager = new NetworkManager();
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub
		txt_member = (TextView) main.findViewById(R.id.txt_member);
	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub
		manager.getMembers(new RequestParams(), new Callback<List<Member>>() {

			@Override
			public void execute(List<Member> response) {
				// TODO Auto-generated method stub
				memberList = response;
				handler.sendEmptyMessage(CherryConfig.UPDATE_MEMBER);
			}
		}, new Callback<Exception>() {

			@Override
			public void execute(Exception response) {
				// TODO Auto-generated method stub
				handleExceptions(response);
			}
		});
	}

	private void handleExceptions(Exception e) {
		// Do Something
		ErrorTerminator.handleError(getActivity(), (GeneralError) e,
				new IDialogCallback() {

					@Override
					public void positive() {
						// TODO Auto-generated method stub

					}

					@Override
					public void negative() {
						// TODO Auto-generated method stub

					}
				});
	}

	Handler handler = new Handler(new Handler.Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			// TODO Auto-generated method stub

			switch (msg.what) {
			case CherryConfig.UPDATE_MEMBER:
				updateMember();

				break;

			default:

				break;
			}

			return false;
		}
	});

	private void updateMember() {

		Log.d("MainActivity", memberList.toString());
		txt_member.setText(memberList.toString());
	}

}
