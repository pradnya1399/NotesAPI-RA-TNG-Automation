package notesapi;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getnotesbyid {

	public static void main(String[] args) {
		List<String> notes = getallnotedetails.retrivenotes();
		String newtoken = TokenManager.getToken();
		String user_id = profile.getprofiledetails();
		
		try {
			
		Response response= RestAssured.given().header("x-auth-token", newtoken)
		.pathParam("id", notes.get(0))
		.when().get("https://practice.expandtesting.com/notes/api/notes/{id}");
		Map<String, Object> body=response.as(Map.class);
		//System.out.println(body);
		
		Map<String, Object> data= (Map<String, Object>) body.get("data");
		String ID= data.get("user_id").toString();
		//System.out.println(ID);
		
		assert user_id==ID:"User id not matching";
		
		long time = response.getTime();
		assert time<2000:" response Time is slow";
		
		assert response.getStatusCode()==200:"status codes npt matching";
		
		assert body.containsKey("message") && "Note successfully retrieved".equals("message"):"note not found";
		
		//assert body.get("message").equals("Note successfully retrieved"):"note not found";
		
		}
		catch(Exception e)
		{
			System.out.println("Exception caught "+e.getCause());
		}
		
		//.then().log().all().statusCode(200);
		
	
		
		
	}

}
