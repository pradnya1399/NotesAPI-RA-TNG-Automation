package notesapi;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

public class createnote {
	
	public static String id1;
	
	public static String note1()
	{
		String newtoken = TokenManager.getToken();
		Response notedetails= RestAssured.given().header("accept","application/json").contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.header("x-auth-token",newtoken)
				.formParam("title", "note1").formParam("description", "first ever note").formParam("category", "Home")
				.when().post("https://practice.expandtesting.com/notes/api/notes");
				//.then().log().all().statusCode(200).assertThat().body("message", equalTo("Note successfully created")).extract().asPrettyString();
				
				/*JsonPath js1= notedetails.jsonPath();
				id1 = js1.getString("data.id");*/
			
				Map<String, Object> body= notedetails.as(Map.class);
				System.out.println(body);
				Map<String, Object> data= (Map<String, Object>) body.get("data");
				
				id1=data.get("id").toString();
				
				assert body.get("message").equals("Note successfully created"):"message not expected";
		
				return id1;		
				
				
				
	}


	public static void main(String[] args) {
		
		createnote c1 = new createnote();
		c1.note1();

	}

}
