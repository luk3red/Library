package manager;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.*;
import DAO.DAORichieste;
import DTO.*;

public class RichiesteManager {
	
	public String Richiedi(String username, String ID_libreria) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOrichiesteint DAORichieste = new DAORichieste();                 //ISTANZIA UN OGGETTO DI WRAPPER
			response = DAORichieste.Richiedi(connection,username,ID_libreria);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response); 
		return response;
	}
	
	
	public ArrayList<Richieste> ListaRichieste(String username) throws Exception{      
		ArrayList<Richieste> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOrichiesteint DAORichieste = new DAORichieste();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAORichieste.ListaRichieste(connection,username);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}

}
