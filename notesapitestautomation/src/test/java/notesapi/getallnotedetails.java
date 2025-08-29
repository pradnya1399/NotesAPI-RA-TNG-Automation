package notesapi;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class getallnotedetails {

	public static void main(String[] args) {
		String newtoken = TokenManager.getToken();
		String response = RestAssured.given().header("x-auth-token",newtoken)
		.header("accept","application/json")
		.when().get("https://practice.expandtesting.com/notes/api/notes")
		.then().log().all().statusCode(200).assertThat().body("message", equalTo("Notes successfully retrieved"))
		.extract().asPrettyString();
	}

}
