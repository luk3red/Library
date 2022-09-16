package manager;
import DAO.*;
import DTO.*;
//import data.Database;


import java.sql.Connection;
import java.util.ArrayList;

public class LibreriaManager {
	public ArrayList<Libreria> ListaLibreria() throws Exception{      
		ArrayList<Libreria> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.ListaLibrerie(connection);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	public ArrayList<Libreria> ListaLibreriaUser(String Username) throws Exception{      
		ArrayList<Libreria> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.ListaLibUser(connection,Username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	public ArrayList<Libreria> ListaLibreriaCUser(String Username) throws Exception{      
		ArrayList<Libreria> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.ListaLibCUser(connection,Username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	public ArrayList<Libreria> ListaLibreriaCwUser(String Username) throws Exception{      
		ArrayList<Libreria> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.ListaLibCwUser(connection,Username);
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
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.LibPub(connection,id_libreria,username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;}
	
	
	public ArrayList<Libreria> ListaLibpubb() throws Exception{      
		ArrayList<Libreria> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOLibreria.ListaLibpubb(connection);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	public String CreaLib(String username, String nomelib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.CreaLib(connection,username,nomelib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String CreaLibCond(String username, String nomelib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.CreaLibCond(connection,username,nomelib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	public String Modnomelib(String nome,String idlib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.Modnomelib(connection,nome,idlib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String Modnomelibc(String nome,String idlib) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.Modnomelibc(connection,nome,idlib);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	
	public String PubLib(String idlib, String username) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.PubLib(connection,idlib, username);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}

	
	public String EliminaLib(String id,String username) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOlibint DAOLibreria = new DAOLibreria();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOLibreria.EliminaLib(connection,id,username);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
}
