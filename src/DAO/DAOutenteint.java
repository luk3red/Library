package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.Utente;

public interface DAOutenteint {

	boolean LogIn(Connection connection, String username, String password) throws Exception;

	String Registrazione(Connection connection, String CF, String nome, String cognome, String email, String username,
			String password) throws Exception;

	//aok
	ArrayList<Utente> ListaUtenti(Connection connection) throws Exception;

	String Eliminazione(Connection connection, String CF) throws Exception;

	String ModUser(Connection connection, String username, String usernamev) throws Exception;

	//aok
	String ModPass(Connection connection, String username, String password) throws Exception;

}