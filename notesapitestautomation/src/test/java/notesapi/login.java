package notesapi;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;

public class login {

	public static void main(String[] args) {
		String Response=RestAssured.given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
		.formParams("email", "prad123@gmail.com","password","abc@123")
		.when().post("https://practice.expandtesting.com/notes/api/users/login")
		.then().statusCode(200).assertThat().body("message",equalTo("Login successful")).extract().asPrettyString();
		System.out.println(Response);
		JsonPath js= new JsonPath(Response);
		String token= js.getString("data.token");
		System.out.println(token);
	}

}
