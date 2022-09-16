package manager;

import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;

import DTO.*;

public class accessiManager {

public String Permesso(String ID_utente,String ID_owner, String ID_libreria) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOaccessiInteface ac = new DAOaccessi();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=ac.Permesso(connection,ID_utente,ID_owner,ID_libreria);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}


}
