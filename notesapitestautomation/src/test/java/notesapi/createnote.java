package notesapi;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

public class createnote {
	
	public static String id1;
	
	public static String note1()
	{
		String newtoken = TokenManager.getToken();
		String notedetails= RestAssured.given().header("accept","application/json").contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.header("x-auth-token",newtoken)
				.formParam("title", "note1").formParam("description", "first ever note").formParam("category", "Home")
				.when().post("https://practice.expandtesting.com/notes/api/notes")
				.then().log().all().statusCode(200).assertThat().body("message", equalTo("Note successfully created")).extract().asPrettyString();
				
				JsonPath js1= new JsonPath(notedetails);
				id1 = js1.getString("data.id");
				return id1;
	}


	public static void main(String[] args) {
		
		createnote c1 = new createnote();
		c1.note1();

	}

}
