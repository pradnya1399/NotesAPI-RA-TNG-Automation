package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class profile {

	public static void main(String[] args) {
		String newtoken = TokenManager.getToken();
		
		//System.out.println(newtoken);
		RestAssured.given().header("x-auth-token",newtoken)
		.header("accept","application/json")
		.when().get("https://practice.expandtesting.com/notes/api/users/profile")
		.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile successful"));
	}

}
