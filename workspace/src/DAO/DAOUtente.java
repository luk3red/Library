package DAO;

import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAOUtente implements DAOutenteint {


@Override
public boolean LogIn(Connection connection, String username, String password) throws Exception{
		boolean response = false;
		try {
			
			PreparedStatement ps = connection.prepareStatement("Select A.* from Utente as A where A.Username=? and A.Password=?");
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
	
	@Override
	public String Registrazione(Connection connection,String CF, String nome, String cognome, String email, String username, String password) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("Insert into Anagrafica(CF, Nome, Cognome, Email) values (?,?,?,?)");
			ps.setString(1, CF);	
			ps.setString(2, nome);
			ps.setString(3, cognome);
			ps.setString(4, email);
			
			PreparedStatement ps2 = connection.prepareStatement("Insert into Utente(COD_FISC, username, password, permessi) values (?,?,?,0)");
			ps2.setString(1, CF);	
			ps2.setString(2, username);
			ps2.setString(3, password);
			
			
			int rs = ps.executeUpdate();	
			int rj = ps2.executeUpdate();
			if(rs == 1 && rj == 1)
				return "true";
			else
				return "false";
			
			
			
		}catch (Exception e) {
			throw e;
		}
	}
	//aok
	@Override
	public ArrayList<Utente> ListaUtenti(Connection connection) throws Exception {
		ArrayList<Utente> Query = new ArrayList<>();
		try {
		
			PreparedStatement ps = connection.prepareStatement
				("Select A.*, C.* From Anagrafica as A join Utente as C on (A.CF = C.COD_FISC)");
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Utente utente = new Utente();
				Anagrafica anagrafica = new Anagrafica(rs.getString("CF"), rs.getString("Nome"), rs.getString("Cognome"),rs.getString("Email")); 
				utente.setUID(rs.getInt("UID"));
				utente.setUsername(rs.getString("Username"));
				utente.setPassword(rs.getString("Password"));
				utente.setPermessi(rs.getByte("Permessi"));
				utente.setAnagrafica(anagrafica);  
				Query.add(utente);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
				
	}
	
	@Override
	public String Eliminazione(Connection connection,String CF) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Anagrafica WHERE CF=?");
			ps.setString(1, CF);
			
			
			int rs = ps.executeUpdate();	
			if(rs == 1)
				return "true";
			else
				return "false";
			
			
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String ModUser(Connection connection,String username, String usernamev) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("UPDATE Utente SET Username=? WHERE Username=?");
		ps.setString(1,username);
		ps.setString(2,usernamev);
		
		
		int rs = ps.executeUpdate();
		if(rs == 1)
			return "true";
		else
			return "false";
		
		
		
	}catch (Exception e) {
		throw e;
	}
}
//aok
@Override
public String ModPass(Connection connection,String username, String password) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("UPDATE Utente SET Password=? WHERE Username=?");
		ps.setString(1,password);
		ps.setString(2,username);
		
		
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
