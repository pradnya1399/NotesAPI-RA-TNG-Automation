package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class deletenote {

	public static void main(String[] args) {
		List<String> notes = getallnotedetails.retrivenotes();
		String newtoken = TokenManager.getToken();
		RestAssured.given()
		.header("x-auth-token",newtoken)
		.pathParam("id", notes.get(1))
		.when().delete("https://practice.expandtesting.com/notes/api/notes/{id}")
		.then().statusCode(200).assertThat().body("message", equalTo("Note successfully deleted"));
		
		
		
	}

}
