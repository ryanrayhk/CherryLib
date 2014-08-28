package com.cherrypicks.lib.ui.fragment;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cherrypicks.lib.R;

/**
 * JsonParseFragment, fragment for demonstrating the json-parse usage.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class JsonParseFragment extends BaseFragment {

	private TextView txt_member;

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

	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub
		txt_member = (TextView) main.findViewById(R.id.txt_member);
	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub
		getInfo();
	}

	public void getInfo() {
		
		new AsyncTask<Void, Void, String>(){

			@Override
			protected String doInBackground(Void... arg0) {
				// TODO Auto-generated method stub
				String url = "https://staging.app.genkisushi.com.hk:8443/genkicms/api/user/getTimestamp.do";
				HttpPost httpost = new HttpPost(url);
				String responseBody = null;
				try {

					HttpClient httpclient = new DefaultHttpClient();
					HttpResponse response = httpclient.execute(httpost);
					InputStream in = response.getEntity().getContent();

					BufferedInputStream bis = new BufferedInputStream(
							in);
					ByteArrayOutputStream buf = new ByteArrayOutputStream();
					int result = bis.read();
					while (result != -1) {
						byte b = (byte) result;
						buf.write(b);
						result = bis.read();
					}

					responseBody = buf.toString();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return responseBody;
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				
				txt_member.setText(result);
			}
			
			
			
		}.execute();
		
		
	}

}
