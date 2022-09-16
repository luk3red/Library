package web.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Serviceutenteint {

	String ListaUtenti();

	Response Registrazione(InputStream input) throws Exception;

	Response Elimina(InputStream input) throws Exception;

	Response ModUser(InputStream input) throws Exception;

	Response ModPass(InputStream input) throws Exception;

}