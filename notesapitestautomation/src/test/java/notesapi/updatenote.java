package notesapi;

import io.restassured.RestAssured;

public class updatenote {

	public static void main(String[] args) {
		String id= createnote.note1();
		String newtoken = TokenManager.getToken();
		RestAssured.given().header("accept","application/json").
		header("x-auth-token",newtoken)
		.contentType("application/x-www-form-urlencoded; charset=UTF-8")
		.formParams("title", "pradnyanotes","description","notetitleandcategoryupdated","completed","true","category","Work")
		.pathParam("id", id)
		//.when().put("https://practice.expandtesting.com/notes/api/notes/" +id)....alertnate way for passing path param when pathparam() not defined
		.when().put("https://practice.expandtesting.com/notes/api/notes/{id}")
		.then().log().all().statusCode(200);
	}

}
