package notesapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class updateprofile {

	public static void main(String[] args) {
		String newtoken = TokenManager.getToken();
		
		Response response= RestAssured.given().header("x-auth-token",newtoken)
		.contentType("application/x-www-form-urlencoded; charset=UTF-8").header("accept","application/json")
		.formParam("name", "pradnyagaikwad").formParam("phone", "1234567890").formParam("company", "vuclip")
		.when().patch("https://practice.expandtesting.com/notes/api/users/profile");
		//.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile updated successful"));
		
		JsonPath js = response.jsonPath();
		String name= js.getString("data.name");
		//System.out.println(name);
		//assert name.equals("pradnyabalajigaikwad"):"name field not updated";
		assert response.statusCode()==200:"status codes is not correct";
		
		//System.out.println(response.time());
		
		assert response.time()<1000:"response time is slow";
		

		
	}

}
