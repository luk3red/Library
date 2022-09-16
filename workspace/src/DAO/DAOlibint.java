package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.Libreria;
import DTO.Media;

public interface DAOlibint {

	ArrayList<Libreria> ListaLibpubb(Connection connection) throws Exception;

	ArrayList<Libreria> ListaLibrerie(Connection connection) throws Exception;

	ArrayList<Libreria> ListaLibUser(Connection connection, String Username) throws Exception;

	ArrayList<Libreria> ListaLibCUser(Connection connection, String Username) throws Exception;

	//lista di librerie condivise con un utente
	ArrayList<Libreria> ListaLibCwUser(Connection connection, String Username) throws Exception;

	String CreaLibCond(Connection connection, String username, String nomelibreria) throws Exception;

	ArrayList<Media> LibPub(Connection connection, String id_libreria, String username) throws Exception;

	String Modnomelib(Connection connection, String nome, String idlib) throws Exception;

	String Modnomelibc(Connection connection, String nome, String idlib) throws Exception;

	String PubLib(Connection connection, String idlib, String username) throws Exception;

	String EliminaLib(Connection connection, String id, String username) throws Exception;

	String CreaLib(Connection connection, String username, String nomelibreria) throws Exception;

}