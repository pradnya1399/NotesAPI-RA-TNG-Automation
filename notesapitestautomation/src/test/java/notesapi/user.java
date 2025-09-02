package notesapi;

public class user {
	
	private String name;
	private String email;
	private String password;
	

	public user(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;	
		
	}
	
	public String  getname()
	{
		return name;
	}
	
	public String  getemail()
	{
		return email;
	}
	
	public String  getpassword()
	{
		return password;
	}
	
	public void setname(String name)
	{
		this.name=name;		
	}
	
	public void setemail(String email)
	{
		this.name=name;		
	}
	
	public void setpassword(String password)
	{
		this.name=name;		
	}

	public static void main(String[] args) {
				

	}

}
