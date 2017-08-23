package com.askconsultant.common.json;

import com.google.gson.Gson;

public class JsonWriter {

	private JsonWriter() {

	}

	public static String writeToString(final Object object) {
		if (object == null) {
			return "";
		}
		return new Gson().toJson(object);
	}

}
