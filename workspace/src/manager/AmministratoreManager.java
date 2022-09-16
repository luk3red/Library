package manager;

import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;

import DTO.*;

public class AmministratoreManager {

public boolean LogInAmm(String username, String password) throws Exception{
		boolean response=false;
		try {
			 
			Database database = new Database();					// CHIAMA IL DATABASE E STABILISCI CONNESSIONE
			Connection connection = database.Get_Connection();
			DAOAMMint amm = new DAOAmministratore();					 //ISTANZIA UN OGGETTO DI WRAPPER
			response=amm.LogInAmm(connection,username,password);
		}catch(Exception e) {
			throw(e);
		
		}System.out.println(response);
		return response;
	}


}
