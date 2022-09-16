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

public interface Serviceutentecondint {

	String ListaUtentiCond(String IDC);

	Response AggALibCond(InputStream input) throws Exception;

	Response Assegna(InputStream input) throws Exception;

}