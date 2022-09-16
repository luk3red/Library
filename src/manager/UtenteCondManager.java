package manager;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.*;
import DTO.*;
public class UtenteCondManager {
	
	public ArrayList<UtenteCond> ListaUserCond(String IDC) throws Exception{      
		ArrayList<UtenteCond> Query = null;
		
		try {
			Database database = new Database();                // CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutentecondint DAOUtenteCond = new DAOUtenteCond();                 //ISTANZIA UN OGGETTO DI WRAPPER
			Query = DAOUtenteCond.ListaUserCond(connection, IDC);
		}catch(Exception e) {
			throw(e);
			
		}
		return Query;
		
	}

	
	public String AggALibCond(String username, String idc, String owner) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutentecondint DAOUtenteCond = new DAOUtenteCond();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOUtenteCond.AggALibCond(connection,username,idc, owner);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
	public String Assegna(String uid, String idc, String owner) throws Exception{
		String response="false";
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOutentecondint DAOUtenteCond = new DAOUtenteCond();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=DAOUtenteCond.Assegna(connection,uid, idc, owner);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}
	
}
