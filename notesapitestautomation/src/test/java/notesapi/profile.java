package notesapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.util.Map;


public class profile {
	
	public static String getprofiledetails() {
	String newtoken = TokenManager.getToken();
	
	String user_id=null;
	
	//System.out.println(newtoken);
	Response response =RestAssured.given().header("x-auth-token",newtoken)
	.header("accept","application/json")
	.when().get("https://practice.expandtesting.com/notes/api/users/profile");
	
	
	//.then().log().all().statusCode(200).assertThat().body("message", equalTo("Profile successful")).extract().asPrettyString();
	
	long time = response.getTime();
	
	assert time<2000;
	
	Map<String, Object>  body = response.as(Map.class);
	
	System.out.println(body);
	
	assert body.get("success").equals(true):"request failed";
	
	try
	{
	
	Map<String, Object> data = (Map<String, Object>) body.get("data");
	
	user_id= data.get("id").toString();
	
	}
	catch(Exception e)
	{
		System.out.println(" Exception caught "+e.getCause());
		
	}
	return user_id;
	
	}

	public static void main(String[] args) {
		profile p= new profile();
		p.getprofiledetails();
		
	}

}
