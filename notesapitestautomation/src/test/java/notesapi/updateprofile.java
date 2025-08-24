package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class updateprofile {

	public static void main(String[] args) {
		RestAssured.given().header("x-auth-token","2b743b32f0c04288aa18cf1d522a5099d085963f94d2438bab887b1a69313c82")
		.contentType("application/x-www-form-urlencoded; charset=UTF-8").header("accept","application/json")
		.formParam("name", "pradnyagaikwad").formParam("phone", "1234567890").formParam("company", "vuclip")
		.when().patch("https://practice.expandtesting.com/notes/api/users/profile")
		.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile updated successful"));
	}

}
