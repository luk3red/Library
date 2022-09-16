package DAO;

import java.util.List;

import DTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class DAOMedia implements DAOmediaint {

@Override
public String ModMedia(Connection connection,String id_media,String idlib) throws Exception{
	
	
	try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM media WHERE ID = ? AND COD_LIB=?");
		ps.setString(1,id_media);
		ps.setString(2,idlib);
		
		int c = 0;
		
		//ResultSet rs = ps.executeQuery();
		
		/*int rs = ps.executeUpdate();	
		if(rs == 1)
			return "true";
		else
			return "false";*/
			ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Media media = new Media();
			media.setID(rs.getInt("ID"));
			media.setCOD_LIB(rs.getInt("COD_LIB"));//da vedere
			c = 1;
		}
		
		if(c==1)
			return"true";
		else
			return "false";
		
	}catch (Exception e) {
		throw e;
	}
}

@Override
public ArrayList<Media> ListaMediaLib(Connection connection,String id,String username) throws Exception {
	ArrayList<Media> Query = new ArrayList<>();
	try {
		
		PreparedStatement ps = connection.prepareStatement("Select A.* From media as A join Libreria as C on (A.COD_LIB=? and A.COD_LIB = (Select C.ID where ID_USER=(SELECT UID from Utente where Username=?)))");
		ps.setString(1,id);									
		ps.setString(2,username);						
		
	
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
		throw(e);
	}
	
	return Query;
}

@Override
public ArrayList<Media> ListaMediaLibC(Connection connection,String id,String username) throws Exception {
	ArrayList<Media> Query = new ArrayList<>();
	try {
		
		PreparedStatement ps = connection.prepareStatement("Select * from mediac where COD_LIBC=? and COD_LIBC=(Select IDC from UtentiCond where ID_USER=(SELECT UID from Utente where Username=?) and IDC=?)");
		ps.setString(1,id);									//Select * from mediac where COD_LIBC=? and COD_LIBC=(Select IDC from UtentiCond where ID_USER=(SELECT UID from Utente where Username=?) and IDC=?)
		ps.setString(2, username);
		ps.setString(3, id);
		
	
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
		throw(e);
	}return Query;
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
public String CreaMedia(Connection connection,String nome, String formato, String id, String username) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO media(COD_LIB,OID,Nome,Formato) value(?,(SELECT UID from Utente where Username=?),?,?)");
		ps.setString(1,id);
		ps.setString(2,username);
		ps.setString(3,nome);
		ps.setString(4, formato);
		
		
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
public String CreaMediaC(Connection connection,String nome, String formato, String id, String username) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO mediac(COD_LIBC,OID,Nome,Formato) value((Select IDC from UtentiCond where ID_USER=(Select UID from Utente where Username=?) AND IDC=? AND Permesso=1),(Select UID from Utente where Username=?),?,?)");
		ps.setString(1,username);
		ps.setString(2,id);
		ps.setString(3,username);
		ps.setString(4,nome);
		ps.setString(5,formato);
		
		
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
public String EliminaMedia(Connection connection,String id,String idlib) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM media WHERE ID=? AND COD_LIB=?");
		ps.setString(1,id);
		ps.setNString(2,idlib);
		
		
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
public String EliminaMediac(Connection connection,String id,String idlib) throws Exception{
	
	try {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM mediac WHERE ID=? AND COD_LIBC=?");
		ps.setString(1,id);
		ps.setNString(2,idlib);
		
		
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
