package DAO;
import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAOAnagrafica implements DAOanagraficaint {
	
	@Override
	public String ModAna(Connection connection,String nome, String cognome, String email, String username) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Anagrafica SET nome=?, cognome=?, email=? WHERE CF=(select COD_FISC from Utente Where Username=?)");
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.setNString(4, username);
			
			
			int rs = ps.executeUpdate();
			if(rs == 1)
				return "true";
			else
				return "false";
			
			
			
		}catch (Exception e) {
			throw e;
		}
	}

}
