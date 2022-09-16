package DAO;

import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAOaccessi implements DAOaccessiInteface {
	
	
	@Override
	public String Permesso(Connection connection,String ID_utente,String ID_owner, String ID_libreria) throws Exception{
	
	try {
		
		PreparedStatement ps1 = connection.prepareStatement("INSERT INTO accessi (ID_utente,ID_owner,ID_libreria) value (?,?,?)");
		ps1.setString(1, ID_utente);
		ps1.setString(2, ID_owner);
		ps1.setString(3, ID_libreria);
		int rs1 = ps1.executeUpdate();
		if(rs1 != 1)
			return "false";
		
	
	
	
		PreparedStatement ps = connection.prepareStatement("DELETE from richieste where ID_richiedente = ? and ID_libreria = ?");
		ps.setString(1,ID_utente);
		ps.setString(2,ID_libreria);
		
		int rs = ps.executeUpdate();	
		if(rs == 1)
			return "true";
		else
			return "false";
		}catch(Exception e) {
			throw e;
		}
		
		
	
}
	

}
