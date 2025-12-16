package context;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    public static Response lastResponse;
	private static Map<String,String> productData = new HashMap<>();

	public static void set(String key, String value) {
		productData.put(key,value);
	}

	public static String get(String key){
		return productData.get(key);
	}

	public static void setLastResponse(Response response) {
		lastResponse = response;
	}



}
