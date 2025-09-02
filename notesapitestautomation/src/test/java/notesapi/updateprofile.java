package notesapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

//import java.util.HashMap;
import java.util.*;

public class updateprofile {

	public static void main(String[] args) {
		String newtoken = TokenManager.getToken();
		
		Map<String, Object> requestbody= new HashMap<>();
		requestbody.put("name", "pradnyabalajigaikwad");
		requestbody.put("phone", "1234567890");
		requestbody.put("company", "vuclip");
		
		Response response= RestAssured.given().header("x-auth-token",newtoken)
		.contentType("application/x-www-form-urlencoded; charset=UTF-8").header("accept","application/json")
		.formParams(requestbody)
		.when().patch("https://practice.expandtesting.com/notes/api/users/profile");
		//.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile updated successful"));
		
		JsonPath js = response.jsonPath();
		String name= js.getString("data.name");
		//System.out.println(name);
		//assert name.equals("pradnyabalajigaikwad"):"name field not updated";
		assert response.statusCode()==200:"status codes is not correct";
		
		//System.out.println(response.time());
		
		assert response.time()<1000:"response time is slow";
		
		
		assert js.getString("message").equals("Profile updated successful"):"message not correct";
		
		
	}

}
