package notesapi;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TokenManager {
	
	
	private static String token;
	
	
	  public static String getToken() {
		  System.out.println("Inside getToken()...");
	        if (token == null) {
	            token = createToken(); // only first time
	        }
	        return token;
	    }
	
	private static String createToken()
	{
		Response response=RestAssured.given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParams("email", "prad123@gmail.com","password","abc@123")
				.when().post("https://practice.expandtesting.com/notes/api/users/login");
				//System.out.println(response);
				token= response.jsonPath().getString("data.token");
				//System.out.println(token);
		return token;
	}


}
