package DAO;

import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAORichieste implements DAOrichiesteint {
	
	@Override
	public String Richiedi(Connection connection,String username, String ID_libreria) throws Exception{
		
		try {
			
			PreparedStatement ps1 = connection.prepareStatement("Select ID from richieste where ID_richiedente = (select UID from Utente where Username= ?) and ID_libreria = ?");
			ps1.setString(1, username);
			ps1.setString(2, ID_libreria);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.isBeforeFirst()) {
				System.out.println("trov"); 
				return "false2";
				}
		}catch  (Exception e) {
			throw e;
		}
			try {	
			PreparedStatement ps = connection.prepareStatement("INSERT INTO richieste(ID_richiedente,ID_libreria,ID_owner) value((SELECT UID from Utente where Username =?),?,(SELECT ID_USER from Libreria where ID=? and PRIVACY=1))");
			ps.setString(1,username);
			ps.setString(2,ID_libreria);
			ps.setString(3,ID_libreria);
			
			int rs = ps.executeUpdate();	
			if(rs == 1)
				return "true";
			else
				return "false1";
			}catch (Exception e) {
				return "false1";
			}
			
			
		
	}

	
	@Override
	public ArrayList<Richieste> ListaRichieste(Connection connection,String username) throws Exception {
		ArrayList<Richieste> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * from richieste where ID_owner=( SELECT UID from Utente where Username =?)");
			ps.setString(1,username);									 						
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Richieste ric = new Richieste();
				ric.setID_richiedente(rs.getInt("ID_richiedente"));
				ric.setID_libreria(rs.getInt("ID_libreria"));
				ric.setID_owner(rs.getInt("ID_owner"));
				ric.setID(rs.getInt("ID"));
			
				
				Query.add(ric);
			}
		
		}catch(Exception e) {
			throw(e);
		}
		
		return Query;
	}



}
