package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.UtenteCond;

public interface DAOutentecondint {

	ArrayList<UtenteCond> ListaUserCond(Connection connection, String IDC) throws Exception;

	String AggALibCond(Connection connection, String username, String IDC, String owner) throws Exception;

	String Assegna(Connection connection, String uid, String IDC, String owner) throws Exception;

}