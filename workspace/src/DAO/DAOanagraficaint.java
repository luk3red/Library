package DAO;

import java.sql.Connection;

public interface DAOanagraficaint {

	String ModAna(Connection connection, String nome, String cognome, String email, String username) throws Exception;

}