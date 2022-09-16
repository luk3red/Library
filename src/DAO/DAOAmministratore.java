package DAO;

import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAOAmministratore implements DAOAMMint {


@Override
public boolean LogInAmm(Connection connection, String username, String password) throws Exception{
		boolean response = false;
		try {
			
			PreparedStatement ps = connection.prepareStatement("Select A.* from Amministratore as A where A.Username=? and A.Password=?");
			ps.setString(1, username);	
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery();	
			
			while(rs.next()) {	

				if(username.equals(rs.getString("Username")) && password.equals(rs.getString("Password"))) {
				response = true;
				}
			}
		
		}catch (Exception e) {
			throw (e);		
		
		}
		
		return response;

	}
	
	
	



}
