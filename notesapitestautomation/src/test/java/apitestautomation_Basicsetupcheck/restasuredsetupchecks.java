package apitestautomation_Basicsetupcheck;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restasuredsetupchecks {

	static public void test1()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String response = RestAssured
                .given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .response().asString();
        System.out.println(response);
	}	
	public static void main(String[] args) {
		
		restasuredsetupchecks r= new restasuredsetupchecks();
		r.test1();
	}

}
