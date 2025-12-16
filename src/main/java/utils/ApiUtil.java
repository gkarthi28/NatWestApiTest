package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtil {

	public static String BASE_URI = "https://api.restful-api.dev/";

	public static Response post(String path, Object body, ContentType contentType) {
          return given ( )
				.baseUri (BASE_URI)
				.basePath (path)
				.contentType (contentType)
				.body (body)
				  .when ()
				  .post ();
	}

	public static Response get(String path) {
		return given ( )
				.baseUri (BASE_URI)
				.basePath (path)
				.when ()
				.get();
	}

	public static Response delete(String path) {
		return given ( )
				.baseUri (BASE_URI)
				.basePath (path)
				.when ()
				.delete ();
	}
}
