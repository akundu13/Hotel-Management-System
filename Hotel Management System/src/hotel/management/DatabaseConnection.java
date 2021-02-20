package hotel.management;

import java.sql.*;

public class DatabaseConnection 
{
	Connection con;
	Statement state;
	
	public  DatabaseConnection() throws Exception
	{
		String url="";
		String user="";
		String pass="";
		
		//load and register
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create connection
		con=DriverManager.getConnection(url, user, pass);
		
		//create statement
		state=con.createStatement();
	}
	
}
