package DAO;

import java.sql.Connection;

public interface DAOaccessiInteface {

	String Permesso(Connection connection, String ID_utente, String ID_owner, String ID_libreria) throws Exception;

}