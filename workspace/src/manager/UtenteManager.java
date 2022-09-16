package manager;

import DTO.*;
import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;

public class UtenteManager {

	
	public boolean LogIn(String username, String password) throws Exception{
		boolean response=false;
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ut.LogIn(connection,username,password);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	
	public String Registrazione(String CF, String nome, String cognome, String email, String username, String password) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ut.Registrazione(connection,CF,nome,cognome,email,username,password);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public ArrayList<Utente> ListaUtenti() throws Exception{      
		ArrayList<Utente> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = ut.ListaUtenti(connection);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}
	
	
	public String Eliminazione(String CF) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ut.Eliminazione(connection,CF);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String ModUser(String username, String usernamev) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ut.ModUser(connection,username,usernamev);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String ModPass(String username, String password) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutenteint ut = new DAOUtente();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ut.ModPass(connection,username,password);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	
}
