package com.cherrypicks.lib.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.cherrypicks.lib.R;

/**
 * ErrorDialog, custom dialog just for remind user some error occured.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class ErrorDialog extends BaseDialogFragment implements OnClickListener {

	private Bundle bundle;
	private TextView txt_error_message;
	private Button btn_confirm;
	private Button btn_cancel;

	public static ErrorDialog newInstance(Bundle b) {

		ErrorDialog dialog = new ErrorDialog();
		dialog.setArguments(b);

		return dialog;
	}

	public ErrorDialog() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		main = inflater.inflate(R.layout.error_dialog, null);
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
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub
		txt_error_message = (TextView) main
				.findViewById(R.id.txt_error_message);
		btn_cancel = (Button) main.findViewById(R.id.btn_cancel);
		btn_confirm = (Button) main.findViewById(R.id.btn_confirm);

		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getDialog().setCanceledOnTouchOutside(false);
	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub

		bundle = getArguments();

		txt_error_message.setText(bundle.getString("message"));

		btn_cancel.setOnClickListener(this);
		btn_confirm.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_confirm:

			if (null != callback) {
				callback.positive();
			}
			this.dismiss();
			break;
		case R.id.btn_cancel:

			if (null != callback) {
				callback.negative();
			}
			this.dismiss();
			break;
		}

	}

}
