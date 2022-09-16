package DAO;

import java.sql.Connection;

public interface DAOAMMint {

	boolean LogInAmm(Connection connection, String username, String password) throws Exception;

}