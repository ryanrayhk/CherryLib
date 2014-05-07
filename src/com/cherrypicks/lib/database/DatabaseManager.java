package com.cherrypicks.lib.database;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.cherrypicks.lib.model.City;

/**
 * Provide different kinds of operation to the database,including
 * retrieve,insert, update and delete.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class DatabaseManager {

	static private DatabaseManager instance;

	static public void init(Context ctx) {
		if (null == instance) {
			instance = new DatabaseManager(ctx);
		}
	}

	static public DatabaseManager getInstance() {
		return instance;
	}

	private DatabaseHelper helper;

	private DatabaseManager(Context ctx) {
		helper = new DatabaseHelper(ctx);
	}

	private DatabaseHelper getHelper() {
		return helper;
	}

	public List<City> getAllCitys() {
		List<City> cityList = null;

		try {
			cityList = getHelper().getCityDao().queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cityList;
	}

	public void addCity(City city) {
		try {
			getHelper().getCityDao().create(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public City getCityWithId(int cityId) {
		City city = null;

		try {
			city = getHelper().getCityDao().queryForId(cityId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return city;
	}

	public boolean isCityAlreadyExists(String name) {
		List<City> cityList = null;

		try {
			cityList = getHelper().getCityDao().queryBuilder()
					.selectColumns("name").where().eq("name", name).query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (null != cityList && cityList.size() > 0) {
			return true;
		}

		return false;
	}

	public void deleteCity(City city) {
		try {
			getHelper().getCityDao().delete(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCity(City city) {
		try {
			getHelper().getCityDao().update(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refreshCity(City city) {
		try {
			getHelper().getCityDao().refresh(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
