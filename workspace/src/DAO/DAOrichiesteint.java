package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.Richieste;

public interface DAOrichiesteint {

	String Richiedi(Connection connection, String username, String ID_libreria) throws Exception;

	ArrayList<Richieste> ListaRichieste(Connection connection, String username) throws Exception;

}