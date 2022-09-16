package manager;
import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;

import DTO.*;


public class AnagraficaManager {

	public String ModAna(String nome, String cognome, String email, String username) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOanagraficaint project = new DAOAnagrafica();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=project.ModAna(connection,nome,cognome,email,username);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	
}
