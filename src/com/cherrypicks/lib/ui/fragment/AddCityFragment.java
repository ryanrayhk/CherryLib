package com.cherrypicks.lib.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.database.DatabaseManager;
import com.cherrypicks.lib.model.City;

/**
 * AddCityFragment, for add city, input name,population information.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class AddCityFragment extends BaseFragment implements OnClickListener {

	private EditText edt_name;
	private EditText edt_population;
	private Button btn_save;
	private City city;

	private int id;

	public enum Mode {
		UPDATE, SAVE
	};

	private Mode mode;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initValues();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		main = inflater.inflate(R.layout.add_city, null);
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

		DatabaseManager.init(getActivity());
		dbManager = DatabaseManager.getInstance();

		Bundle bundle = getArguments();
		city = new City();
		if (null == bundle) {
			mode = Mode.SAVE;
		} else {
			mode = Mode.UPDATE;
			id = bundle.getInt("id");

		}
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

		edt_name = (EditText) main.findViewById(R.id.edt_name);
		edt_population = (EditText) main.findViewById(R.id.edt_population);
		btn_save = (Button) main.findViewById(R.id.btn_save);

	}

	@Override
	public void bindEvents() {
		// TODO Auto-generated method stub

		if (mode.equals(Mode.SAVE)) {
			btn_save.setText(R.string.txt_save);
		} else {
			btn_save.setText(R.string.txt_update);
			city = dbManager.getCityWithId(id);

			edt_name.setText(city.getName());
			edt_population.setText(String.valueOf(city.getPopulation()));
		}

		btn_save.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		loadData();

		if (mode.equals(Mode.SAVE)) {
			dbManager.addCity(city);
			getActivity().getSupportFragmentManager().popBackStack();
			Toast.makeText(getActivity(), "Add Success", Toast.LENGTH_LONG)
					.show();

		} else {
			dbManager.updateCity(city);
			getActivity().getSupportFragmentManager().popBackStack();
			Toast.makeText(getActivity(), "Update Success", Toast.LENGTH_LONG)
					.show();

		}
		hideKeyboard();
	}

	public void loadData() {
		city.setName(edt_name.getText().toString());
		city.setPopulation(Long.parseLong(edt_population.getText().toString()));
	}

	public void hideKeyboard() {
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

}
