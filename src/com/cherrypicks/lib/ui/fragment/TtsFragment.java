package com.cherrypicks.lib.ui.fragment;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.utils.Logger;

public class TtsFragment extends BaseFragment implements
		TextToSpeech.OnInitListener, OnClickListener {

	private EditText edt_speech;
	private Button btn_speech;

	private TextToSpeech tts;

	private String txt_speech = "French President Francois Hollande has said the EU must reform and scale back its power, amid a surge in support for Eurosceptic and far-right parties";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		initValues();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		main = inflater.inflate(R.layout.tts_fragment, null);

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
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		tts = new TextToSpeech(getActivity(), this);
		logger = Logger.Jlog();
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

		edt_speech = (EditText) main.findViewById(R.id.edt_speech);
		btn_speech = (Button) main.findViewById(R.id.btn_speech);

		btn_speech.setEnabled(false);
		edt_speech.setText(txt_speech);

	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub
		btn_speech.setOnClickListener(this);
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.UK);

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				logger.e("This Language is not supported");
			} else {
				btn_speech.setEnabled(true);
				speakOut();
			}

		} else {
			logger.e("Initilization Failed!");
		}
	}

	private void speakOut() {

		String text = edt_speech.getText().toString();

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_speech:

			speakOut();
			break;

		default:
			break;
		}
	}

}
