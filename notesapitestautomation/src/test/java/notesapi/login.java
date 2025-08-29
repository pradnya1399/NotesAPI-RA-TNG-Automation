package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;

public class login {
	
	public void loginuser()
	{
		RestAssured.given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParams("email", "prad123@gmail.com","password","abc@123")
				.when().post("https://practice.expandtesting.com/notes/api/users/login")
				.then().statusCode(200).assertThat().body("message",equalTo("Login successful")).extract().asPrettyString();
				
	}

	public static void main(String[] args) {
		login l1= new login();
		l1.loginuser();
		
	}

}
