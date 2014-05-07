package com.cherrypicks.lib.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cherrypicks.lib.R;
import com.cherrypicks.lib.model.City;
import com.cherrypicks.lib.protocol.IListItemClick;

/**
 * CityAdapter, example of how should we use adapter to organize data and
 * display them on layout.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class CityAdapter extends BaseAdapter {

	private IListItemClick onListItemClick;
	private LayoutInflater inflator;
	private List<City> cityList;

	public CityAdapter(Context context, IListItemClick onListItemClick) {

		this.onListItemClick = onListItemClick;
		inflator = LayoutInflater.from(context);
		cityList = new ArrayList<City>();
	}

	public void setData(List<City> cityList) {

		this.cityList.clear();
		this.cityList.addAll(cityList);
	}

	public void addDataCollection(List<City> cityList) {
		this.cityList.addAll(cityList);
	}

	public void addData(City city) {
		this.cityList.add(city);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cityList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return cityList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return cityList.get(arg0).getId();
	}

	@Override
	public View getView(int arg0, View arg1, final ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;

		if (arg1 == null) {
			arg1 = inflator.inflate(R.layout.database_list_item, null);
			holder = new ViewHolder();

			holder.txt_item = (TextView) arg1.findViewById(R.id.txt_item);
			holder.btn_delete = (Button) arg1.findViewById(R.id.btn_delete);
			holder.btn_edit = (Button) arg1.findViewById(R.id.btn_edit);

			arg1.setTag(holder);

		} else {
			holder = (ViewHolder) arg1.getTag();
		}

		holder.txt_item.setText(cityList.get(arg0).getName());

		final View view = arg1;
		final int position = arg0;

		final int editID = holder.btn_edit.getId();
		final int delId = holder.btn_delete.getId();

		holder.btn_edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onListItemClick.onClick(view, arg2, position, editID);
			}
		});

		holder.btn_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onListItemClick.onClick(view, arg2, position, delId);
			}
		});

		return arg1;
	}

	/**
	 * Inner static class which contain the widgets of the list item.
	 * 
	 * @author jerryzhang
	 * 
	 */
	static class ViewHolder {
		TextView txt_item;
		Button btn_edit;
		Button btn_delete;
	}

}
