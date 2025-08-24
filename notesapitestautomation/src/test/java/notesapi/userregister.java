package notesapi;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
public class userregister {
	
	
	public static void register()
	{
		RestAssured.given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
		.formParam("name", "pradnyag").formParam("email", "prad123@gmail.com").formParam("password", "abc@123")
		.when().post("https://practice.expandtesting.com/notes/api/users/register")
		.then().statusCode(201).log().all().assertThat().body("message", equalTo("User account created successfully"));	
	}

	public static void main(String[] args) {
		
		userregister u= new userregister();
		u.register();
	}

}
