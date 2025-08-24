package notesapi;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class healthcheckurl {

	public static void getdata()
	{
		
			RestAssured.given().header("accept","application/json")
			.when().get("https://practice.expandtesting.com/notes/api/health-check")
			.then().log().all().statusCode(200).assertThat().body("success", equalTo(true)).and().body("message", equalTo("Notes API is Running")).and().body("status", equalTo(200))
			;				
	}
	
public static void main(String args[])
{
	healthcheckurl h= new healthcheckurl();
	h.getdata();
	
}


}

