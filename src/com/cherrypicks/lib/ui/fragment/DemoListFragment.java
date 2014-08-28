package com.cherrypicks.lib.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.ui.dialog.DialogManager;
import com.cherrypicks.lib.utils.CherryConfig;
import com.cherrypicks.lib.utils.Logger;

/**
 * DemoListFragment, list the module item for demonstrating.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class DemoListFragment extends BaseFragment {

	private ListView list_demo;
	private ArrayAdapter<String> adapter;
	private String[] array = { "Http Request", "Gcm", "Database", "Json Parse",
			"UnZip", "FaceBook", "Location", "TTS" };

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
		main = inflater.inflate(R.layout.main_fragment, null);
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
		// adapter = new ArrayAdapter<String>(getActivity(),
		// R.layout.demo_list_item, R.id.txt_item, array);

		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, array);
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

		list_demo = (ListView) main.findViewById(R.id.list_demo);
	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub

		list_demo.setAdapter(adapter);
		list_demo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case CherryConfig.LOOPER_HTTP_REQUEST:

					getFragmentTransaction();
					ft.replace(R.id.layout_container, new NetworkDemoFragment());
					ft.addToBackStack("Menu");
					ft.commit();

					break;
				case CherryConfig.LOOPER_GCM:
					break;
				case CherryConfig.LOOPER_DATABASE:
					getFragmentTransaction();
					ft.replace(R.id.layout_container,
							new DatabaseDemoFragment());
					ft.addToBackStack("Menu");
					ft.commit();

					break;
				case CherryConfig.LOOPER_JSON:
					getFragmentTransaction();
					ft.replace(R.id.layout_container, new JsonParseFragment());
					ft.addToBackStack("Menu");
					ft.commit();
					break;
				case CherryConfig.LOOPER_UNZIP:

					Bundle bundle = new Bundle();
					bundle.putString("message", "Just for test");

					getFragmentTransaction();
					DialogManager.showErrorDialog(ft, bundle, null);

					break;
				case CherryConfig.LOOPER_FACEBOOK:

					break;
				case CherryConfig.LOOPER_LOCATION:
					getFragmentTransaction();
					ft.replace(R.id.layout_container,
							new TestLocationFragment());
					ft.addToBackStack("location");
					ft.commit();
					break;
				case CherryConfig.LOOPER_TTS:

					getFragmentTransaction();
					ft.replace(R.id.layout_container, new TtsFragment());
					ft.addToBackStack("tts");
					ft.commit();
					break;
				}
			}

		});

	}

}
