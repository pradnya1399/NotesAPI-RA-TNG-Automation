package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class profile {

	public static void main(String[] args) {
		RestAssured.given().header("x-auth-token","2b743b32f0c04288aa18cf1d522a5099d085963f94d2438bab887b1a69313c82")
		.header("accept","application/json")
		.when().get("https://practice.expandtesting.com/notes/api/users/profile")
		.then().statusCode(200).assertThat().body("message", equalTo("Profile successful"));
	}

}
