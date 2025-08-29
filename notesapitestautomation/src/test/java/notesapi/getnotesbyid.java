package notesapi;

import java.util.List;

import io.restassured.RestAssured;

public class getnotesbyid {

	public static void main(String[] args) {
		//List<String> notes = getallnotedetails.retrivenotes();
		
		String newtoken = TokenManager.getToken();
		RestAssured.given().header("x-auth-token", newtoken)
		//.pathParam("id", notes.get(1))
		.when().get("https://practice.expandtesting.com/notes/api/notes/68b15d6b6f7da0028a4b3e46")
		.then().log().all().statusCode(200);
		
		
	}

}
