package url_endpoints;

	import java.util.HashMap;
	import static org.hamcrest.Matchers.equalTo;

	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	public class REQRES_URL {
	
	
		@Test(priority='1')
		public void baseurl() {
			
			RestAssured
			.given()
			.baseUri("https://reqres.in/api")
			.when().get()
			.then().statusCode(404).log().all();
			
		}
		
		@Test(priority='2')
			public void RegsiterUrl() {
			
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "eve.holt@reqres.in");
			map.put("password", "pistol");
		
		
				RestAssured
				.given()
				.baseUri("https://reqres.in/api")
				.basePath("/register")
				.contentType("application/json; charset=utf-8")
				.body(map)
				.when().post()
				.then().statusCode(200).log().all();
				
				
			}
		@Test(priority='3')
		public void GetUser() {
			
			RestAssured
			.given()
			.baseUri("https://reqres.in")
			.basePath("api/users")
			.when().get()
			.then()
			.body("data[0].email",equalTo("george.bluth@reqres.in"),
					  "data[0].first_name", equalTo("George"),
					  "data[0].last_name", equalTo("Bluth"),
					  "data[0].avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"));// after then, we are validating the request
			
			
			
			
		}
		
		@Test(priority='4')
		public void Loggingtest() {
			RestAssured
			.given()
			.baseUri("https://reqres.in")
			.basePath("/api/unknown")
			.when().get()
			.then().statusCode(200).log().all();	}
		
		
		}



