package com.askconsultant.common.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Utility class for JSON
 *
 */
public final class JsonUtils {

	private static final String _ID = "id";

	private JsonUtils() {
	}

	public static JsonElement getJsonElementWithId(final Long id) {
		final JsonObject idJson = new JsonObject();
		idJson.addProperty(_ID, id);

		return idJson;
	}

}