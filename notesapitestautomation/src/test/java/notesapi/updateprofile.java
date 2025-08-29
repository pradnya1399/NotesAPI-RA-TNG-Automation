package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class updateprofile {

	public static void main(String[] args) {
		String newtoken = TokenManager.getToken();
		RestAssured.given().header("x-auth-token",newtoken)
		.contentType("application/x-www-form-urlencoded; charset=UTF-8").header("accept","application/json")
		.formParam("name", "pradnyagaikwad").formParam("phone", "1234567890").formParam("company", "vuclip")
		.when().patch("https://practice.expandtesting.com/notes/api/users/profile")
		.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile updated successful"));
	}

}
