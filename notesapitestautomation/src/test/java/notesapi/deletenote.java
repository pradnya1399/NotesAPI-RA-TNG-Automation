package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class deletenote {

	public static void main(String[] args) {
		String id = createnote.note1();
		String newtoken = TokenManager.getToken();
		RestAssured.given()
		.header("x-auth-token",newtoken)
		.pathParam("id", id)
		.when().delete("https://practice.expandtesting.com/notes/api/notes/{id}")
		.then().statusCode(200).assertThat().body("message", equalTo("Note successfully deleted"));
		
		
		
	}

}
