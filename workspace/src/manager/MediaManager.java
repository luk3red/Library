package manager;

import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;

import DTO.*;

public class MediaManager {

public String ModMedia(String id_media,String idlib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=man.ModMedia(connection,id_media,idlib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public ArrayList<Media> ListaMediaLib(String id,String username) throws Exception{      
		ArrayList<Media> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = man.ListaMediaLib(connection,id,username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	public ArrayList<Media> ListaMediaLibC(String id,String username) throws Exception{      
		ArrayList<Media> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = man.ListaMediaLibC(connection,id,username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
			
		
	}
	
	public ArrayList<Media> LibPub(String id_libreria,String username) throws Exception{      
		ArrayList<Media> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = man.LibPub(connection,id_libreria,username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;}
		
		public String CreaMedia(String nome, String formato, String id, String username) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=man.CreaMedia(connection,nome,formato,id,username);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String CreaMediaC(String nome, String formato, String id, String username) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=man.CreaMediaC(connection,nome,formato,id,username);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String EliminaMedia(String id,String idlib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=man.EliminaMedia(connection,id,idlib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String EliminaMediaC(String id,String idlib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOmediaint man = new DAOMedia();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=man.EliminaMediac(connection,id,idlib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}



}
