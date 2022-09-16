package web.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Servicemediaint {

	String ListaMediaLib(String id, String username);

	String ListaMediaLibC(String id, String username);

	String LibPub(String id_libreria, String username);

	Response ModMedia(InputStream input) throws Exception;

	Response CreaMedia(InputStream input) throws Exception;

	Response CreaMediaC(InputStream input) throws Exception;

	Response EliminaMedia(InputStream input) throws Exception;

	Response EliminaMediaC(InputStream input) throws Exception;

}