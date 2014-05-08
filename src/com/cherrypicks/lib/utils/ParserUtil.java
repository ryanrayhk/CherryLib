package com.cherrypicks.lib.utils;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * ParseUtil, Parse json data and return collection or model.
 * @author Benkwan
 *
 * @param <T>
 */
public class ParserUtil<T> {
	
	public List<T> getMemberList(final String str)
	{
		try {
			FutureTask<List<T>> task = new FutureTask<List<T>>(
					new Callable<List<T>>() {

						@Override
						public List<T> call() throws Exception {

							Gson gson = new GsonBuilder().create();
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(str);
							JsonArray jsonArray = element.getAsJsonObject()
									.get("results").getAsJsonObject()
									.get("members").getAsJsonArray();

							Type typeOfCollectionOfMember = new TypeToken<Collection<T>>() {
							}.getType();
							return gson.fromJson(jsonArray,
									typeOfCollectionOfMember);
						}

					});

			ThreadPoolUtil.getInstance().execute(task);

			return task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public T getMember(final String str)
	{
		
		try {
			FutureTask<T> task = new FutureTask<T>(
					new Callable<T>() {

						@Override
						public T call() throws Exception {

							Gson gson = new GsonBuilder().create();
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(str);
							JsonArray jsonArray = element.getAsJsonObject()
									.get("results").getAsJsonObject()
									.get("members").getAsJsonArray();

							Type typeOfOfMember = new TypeToken<T>() {
							}.getType();
							return gson.fromJson(jsonArray,
									typeOfOfMember);
						}

					});

			ThreadPoolUtil.getInstance().execute(task);

			return task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
