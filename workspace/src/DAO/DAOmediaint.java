package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.Media;

public interface DAOmediaint {

	String ModMedia(Connection connection, String id_media, String idlib) throws Exception;

	ArrayList<Media> ListaMediaLib(Connection connection, String id, String username) throws Exception;

	ArrayList<Media> ListaMediaLibC(Connection connection, String id, String username) throws Exception;

	ArrayList<Media> LibPub(Connection connection, String id_libreria, String username) throws Exception;

	String CreaMedia(Connection connection, String nome, String formato, String id, String username) throws Exception;

	String CreaMediaC(Connection connection, String nome, String formato, String id, String username) throws Exception;

	String EliminaMedia(Connection connection, String id, String idlib) throws Exception;

	String EliminaMediac(Connection connection, String id, String idlib) throws Exception;

}