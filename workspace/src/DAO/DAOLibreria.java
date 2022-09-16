package DAO;
import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;



public class DAOLibreria implements DAOlibint {
	
	@Override
	public ArrayList<Libreria> ListaLibpubb(Connection connection) throws Exception {
		ArrayList<Libreria> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Libreria where Privacy = 1");

			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Libreria libreria = new Libreria();
				libreria.setID(rs.getInt("ID"));
				libreria.setID_AMM(rs.getInt("ID_AMM"));
				libreria.setID_User(rs.getInt("ID_USER"));
				libreria.setPrivacy(rs.getByte("Privacy"));
				libreria.setNome(rs.getString("Nome"));
				Query.add(libreria);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
	}

	
	@Override
	public ArrayList<Libreria> ListaLibrerie(Connection connection) throws Exception {
		ArrayList<Libreria> Query = new ArrayList<>();
		try {
			
			String Q = "Select * from Libreria";
			
			PreparedStatement ps = connection.prepareStatement(Q);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Libreria libreria = new Libreria();
				libreria.setID(rs.getInt("ID"));
				libreria.setID_AMM(rs.getInt("ID_AMM"));
				libreria.setID_User(rs.getInt("ID_USER"));
				libreria.setPrivacy(rs.getByte("Privacy"));
				libreria.setNome(rs.getString("Nome"));
				Query.add(libreria);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
				
	}

	@Override
	public ArrayList<Libreria> ListaLibUser(Connection connection,String Username) throws Exception {
		ArrayList<Libreria> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Libreria where ID_USER = (SELECT UID from Utente where Username = ?)");
			ps.setString(1, Username);
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Libreria libreria = new Libreria();
				libreria.setID(rs.getInt("ID"));
				libreria.setID_AMM(rs.getInt("ID_AMM"));
				libreria.setID_User(rs.getInt("ID_USER"));
				libreria.setPrivacy(rs.getByte("Privacy"));
				libreria.setNome(rs.getString("Nome"));
				Query.add(libreria);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
	}
	
	
	@Override
	public ArrayList<Libreria> ListaLibCUser(Connection connection,String Username) throws Exception {
		ArrayList<Libreria> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM LibreriaCond where ID_USER = (SELECT UID from Utente where Username = ?)");
			ps.setString(1, Username);
			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				Libreria libreria = new Libreria();
				libreria.setID(rs.getInt("ID"));
				libreria.setID_AMM(rs.getInt("ID_AMM"));
				libreria.setID_User(rs.getInt("ID_USER"));
				libreria.setPrivacy(rs.getByte("Privacy"));
				libreria.setNome(rs.getString("Nome"));
				Query.add(libreria);
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
	}
	//lista di librerie condivise con un utente
	@Override
	public ArrayList<Libreria> ListaLibCwUser(Connection connection,String Username) throws Exception {
		ArrayList<Libreria> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT IDC from UtentiCond where ID_USER=(SELECT UID from Utente where Username=?)");
			ps.setString(1, Username);										 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer val = rs.getInt("IDC");
				PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM LibreriaCond where ID = ?");
				ps1.setInt(1, val);										 
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
				Libreria libreria = new Libreria();
				libreria.setID(rs1.getInt("ID"));
				libreria.setID_AMM(rs1.getInt("ID_AMM"));
				libreria.setID_User(rs1.getInt("ID_USER"));
				libreria.setPrivacy(rs1.getByte("Privacy"));
				libreria.setNome(rs1.getString("Nome"));
				Query.add(libreria);
			
				}
				
				//UtenteCond cond = new UtenteCond();
				//cond.setIDC(rs.getInt("IDC"));
				//Query.add(cond);
				
				
				
			}
		
		}catch(Exception e) {
			throw(e);
		}return Query;
	}

	@Override
	public String CreaLibCond(Connection connection,String username, String nomelibreria) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO LibreriaCond(ID_AMM,ID_USER,PRIVACY,Nome) value(1,(SELECT UID from Utente where Username=?),0,?)");
			ps.setString(1,username);
			ps.setString(2,nomelibreria);
			int rs = ps.executeUpdate();
		
			PreparedStatement ps1 = connection.prepareStatement("Insert INTO UtentiCond(ID_USER,IDC,Permesso) value((SELECT UID from Utente where Username=?),(Select ID from libreriacond where Nome=?),1)");
			ps1.setString(1,username);
			ps1.setString(2,nomelibreria);
			
			int rs1 = ps1.executeUpdate();	
			if(rs == 1 && rs1 == 1)
				return "true";
			else
				return "false";
			
			
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public ArrayList<Media> LibPub(Connection connection,String id_libreria,String username) throws Exception {
		ArrayList<Media> Query = new ArrayList<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("Select * from media where COD_LIB=? and COD_LIB=(Select ID_libreria from accessi where ID_utente=(SELECT UID from Utente where Username=?) and ID_libreria=?)");
			ps.setString(1,id_libreria);									//Select * from mediac where COD_LIBC=? and COD_LIBC=(Select IDC from UtentiCond where ID_USER=(SELECT UID from Utente where Username=?) and IDC=?)
			ps.setString(2, username);
			ps.setString(3, id_libreria);

			
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Media media = new Media();
				media.setID(rs.getInt("ID"));
				media.setNome(rs.getString("Nome"));
				media.setFormato(rs.getString("Formato"));
				media.setOID(rs.getInt("OID"));
				Query.add(media);
			}
		
		}catch(Exception e) {
			System.out.println("error");
			throw(e);
		}return Query;
	}


	@Override
	public String Modnomelib(Connection connection,String nome,String idlib) throws Exception{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Libreria SET nome=? WHERE ID = ?");
			ps.setString(1,nome);
			ps.setString(2,idlib);
			
			int c = 0;
			
			//ResultSet rs = ps.executeQuery();
			
			/*int rs = ps.executeUpdate();	
			if(rs == 1)
				return "true";
			else
				return "false";*/
			int rs = ps.executeUpdate();
			
			
			if(rs==1)
				return"true";
			else
				return "false";
			
		}catch (Exception e) {
			throw e;
		}
	}


	@Override
	public String Modnomelibc(Connection connection,String nome,String idlib) throws Exception{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE LibreriaCond SET nome=? WHERE ID = ?");
			ps.setString(1,nome);
			ps.setString(2,idlib);
			
			int c = 0;
			
			//ResultSet rs = ps.executeQuery();
			
			/*int rs = ps.executeUpdate();	
			if(rs == 1)
				return "true";
			else
				return "false";*/
			int rs = ps.executeUpdate();
			
			
			if(rs==1)
				return"true";
			else
				return "false";
			
		}catch (Exception e) {
			throw e;
		}
	}


	@Override
	public String PubLib(Connection connection,String idlib, String username) throws Exception{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Libreria SET privacy=1 WHERE ID = ? AND ID_USER=(SELECT UID from Utente where Username=?) ");
			ps.setString(1,idlib);
			ps.setString(2, username);
			
			
			int rs = ps.executeUpdate();
			
			
			if(rs==1)
				return"true";
			else
				return "false";
			
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String EliminaLib(Connection connection,String id,String username) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Libreria WHERE ID=? AND ID_USER=(SELECT UID from Utente where Username=?)");
			ps.setString(1,id);
			ps.setNString(2,username);
			
			
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
	public String CreaLib(Connection connection,String username, String nomelibreria) throws Exception{
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Libreria(ID_AMM,ID_USER,PRIVACY,Nome) value(1,(SELECT UID from Utente where Username=?),0,?)");
			ps.setString(1,username);
			ps.setString(2,nomelibreria);
			
			
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
