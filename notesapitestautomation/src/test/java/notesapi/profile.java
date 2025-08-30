package notesapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;


public class profile {
	
	public static String getprofiledetails() {
	String newtoken = TokenManager.getToken();
	
	//System.out.println(newtoken);
	String response =RestAssured.given().header("x-auth-token",newtoken)
	.header("accept","application/json")
	.when().get("https://practice.expandtesting.com/notes/api/users/profile")
	.then().statusCode(200).assertThat().body("message", equalTo("Profile successful")).extract().asPrettyString();
	
	JsonPath j = new JsonPath(response);
	String user_id=j.getString("data.id");
	
	return user_id;
	
	}

	public static void main(String[] args) {
		profile p= new profile();
		p.getprofiledetails();
		
	}

}
