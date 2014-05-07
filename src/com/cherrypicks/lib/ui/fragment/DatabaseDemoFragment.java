package com.cherrypicks.lib.ui.fragment;

import java.util.List;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.adapter.CityAdapter;
import com.cherrypicks.lib.database.DatabaseManager;
import com.cherrypicks.lib.model.City;
import com.cherrypicks.lib.protocol.IListItemClick;

/**
 * DatabaseDemoFragment, fragment for demonstrating the usage of the database module.
 *
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class DatabaseDemoFragment extends BaseFragment implements
		IListItemClick, OnClickListener {

	private ListView list_data;
	private Button btn_add;
	private List<City> cityList;
	private CityAdapter cityAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initValues();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		main = inflater.inflate(R.layout.database_fragment, null);
		findViews1(main);
		return main;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStart() {
		super.onStart();
		bindEvents();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		populateViewForOrientation(inflater, (ViewGroup) getView());
	}

	private void populateViewForOrientation(LayoutInflater inflater,
			ViewGroup viewGroup) {
		viewGroup.removeAllViewsInLayout();
		View subview = inflater.inflate(R.layout.database_fragment, viewGroup);

		findViews1(subview);
		// Find your buttons in subview, set up onclicks, set up callbacks to
		// your parent fragment or activity here.

		// You can create ViewHolder or separate method for that.
		// example of accessing views: TextView textViewExample = (TextView)
		// view.findViewById(R.id.text_view_example);
		// textViewExample.setText("example");
	}

	@Override
	public void onClick(View item, View group, int position, int id) {
		switch (id) {
		case R.id.btn_edit:

			Bundle bundle = new Bundle();
			bundle.putInt("id", cityList.get(position).getId());

			ft = getActivity().getSupportFragmentManager().beginTransaction();
			AddCityFragment fragment = new AddCityFragment();
			fragment.setArguments(bundle);

			ft.replace(R.id.layout_container, fragment);
			ft.addToBackStack(null);
			ft.commit();

			break;
		case R.id.btn_delete:
			dbManager.deleteCity(cityList.get(position));
			cityList.remove(cityList.get(position));
			cityAdapter.setData(cityList);
			cityAdapter.notifyDataSetChanged();
			break;
		}

	}

	@Override
	public void initValues() {
		DatabaseManager.init(getActivity());
		dbManager = DatabaseManager.getInstance();
		cityAdapter = new CityAdapter(getActivity(), this);

		if (!dbManager.isCityAlreadyExists("Melbourne")) {
			City city = new City();
			city.setName("Melbourne");
			city.setPopulation(4250000);
			dbManager.addCity(city);
		}
	}

	public void findViews1(View view) {
		list_data = (ListView) view.findViewById(R.id.list_data);
		btn_add = (Button) view.findViewById(R.id.btn_add);
	}

	@Override
	public void bindEvents() {

		cityList = dbManager.getAllCitys();

		cityAdapter.setData(cityList);
		list_data.setAdapter(cityAdapter);

		btn_add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:

			ft = getActivity().getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.layout_container, new AddCityFragment());
			ft.addToBackStack(null);
			ft.commit();

			break;
		default:
			break;
		}
	}

	@Override
	public void findViews() {
		// TODO Auto-generated method stub

	}

}
