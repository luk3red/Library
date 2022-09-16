package DAO;
import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;


public class DAOUtenteCond implements DAOutentecondint {
	@Override
	public ArrayList<UtenteCond> ListaUserCond(Connection connection,String IDC) throws Exception {
		ArrayList<UtenteCond> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM UtentiCond where IDC = ?");
			ps.setString(1, IDC);																 
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				UtenteCond userc=new UtenteCond();
				userc.setUID(rs.getInt("ID_USER"));
				userc.setIDC(rs.getInt("IDC"));
				userc.setPermesso(rs.getInt("Permesso"));
				Query.add(userc);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
	}
	
	@Override
	public String AggALibCond(Connection connection,String username, String IDC, String owner) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO UtentiCond(ID_USER,IDC,Permesso) value((SELECT UID from Utente where Username=?),(Select ID from Libreriacond where ID_USER=(SELECT UID from Utente where Username=?) and ID=?),0)");
			ps.setString(1,username);							
			ps.setString(2, owner);								//INSERT INTO UtentiCond(ID_USER,IDC,Permesso) value((SELECT UID from Utente where Username=?),(Select ID from Libreria where ID_USER=(SELECT UID from Utente where Username=?) and ID=?),0)
			ps.setString(3,IDC);
			
			
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
	public String Assegna(Connection connection,String uid, String IDC, String owner) throws Exception{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE UtentiCond SET Permesso=1 WHERE ID_USER = (SELECT UID from Utente where Username=?) AND IDC = (Select ID from LibreriaCond where ID=? AND ID_USER =(SELECT UID from Utente where Username=?))");
			ps.setString(1,uid);
			ps.setString(2, IDC);
			ps.setString(3, owner);
			System.out.println(uid+IDC+owner);
			
			int rs = ps.executeUpdate();
			
			
			if(rs==1)
				return"true";
			else
				return "false";
			
		}catch (Exception e) {
			throw e;
		}
	}



}
