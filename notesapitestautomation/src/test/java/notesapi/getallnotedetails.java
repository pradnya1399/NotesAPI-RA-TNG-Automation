package notesapi;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class getallnotedetails {
	
	
	public static  List retrivenotes()
	{
		String id="";
		
		String newtoken = TokenManager.getToken();
		Response response = RestAssured.given().header("x-auth-token",newtoken)
		.header("accept","application/json")
		.when().get("https://practice.expandtesting.com/notes/api/notes");
		
		JsonPath js= response.jsonPath();
		
		List<Map<String,Object>> notes= js.getList("data");
		
		//Assert list is not empty
		try 
		{
			
		assert notes.size()>0: " List is not empty";
		
		}
		
		catch(AssertionError e)
		
		{
	    	System.out.println("Assertion error caught" +e.getMessage());
			
		}
		/*catch(Exception e)
		{
			System.out.println("Exception caught" +e.getMessage());
		}*/
		
		//Assert reponse time
		assert response.time()<2000: "response time is slow";
		
		
		//storing notes into a list which has title=pradnyanotes
		List<String> idlist = new ArrayList<>();
		
		for(int i=0; i<notes.size();i++)
		{
			String title= notes.get(i).get("title").toString();
			if(title.equals("pradnyanotes"))
			{
				id =  notes.get(i).get("id").toString();
			    idlist.add(id);
			} 
			
			/*assert notes.get(i).get("completed").equals(true):" further notes are not completed";
			System.out.println(notes.get(i));*/
		}
		
		//System.out.println(idlist);

	
		return idlist;
	}
	
	

	public static void main(String[] args) {
		getallnotedetails n1= new getallnotedetails();
		n1.retrivenotes();
		
		
	}

}
