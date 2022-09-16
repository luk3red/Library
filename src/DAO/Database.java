package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

	public static Connection Get_Connection() throws Exception
	{
		
	String connectionURL;
	try
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		connectionURL = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Rome";
		Connection connection = null;
		connection = DriverManager.getConnection(connectionURL, "root", "");
		return connection;
	}
	catch (SQLException e)
	{
	throw e;
	}
	catch (Exception e)
	{
	throw e;
	}
	}
	
	public static void main(String[] args) throws Exception {
		
		Get_Connection();
		
	}
	
}
