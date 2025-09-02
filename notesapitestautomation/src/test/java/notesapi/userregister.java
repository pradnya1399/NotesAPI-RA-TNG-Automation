package notesapi;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
public class userregister {
	

	
	public static void register()
	{
		//user u = new user("pradnya","email@email.com","abc@123"); //We can't use pojo with form params and we can only us it with jsonbody
		
		Map<String ,Object> requestBody = new HashMap<>();
		requestBody.put("name","pradnyagaikwad");
		requestBody.put("email", "prad1234@gmail.com");
		requestBody.put("password", "abc@123");
		
		try {
		RestAssured.given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
		.formParams(requestBody)
		.when().post("https://practice.expandtesting.com/notes/api/users/register")
		.then().statusCode(201).log().all().assertThat().body("message", equalTo("User account created successfully"));	
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	public static void main(String[] args) {
		
		userregister u= new userregister();
		u.register();
	}

}
