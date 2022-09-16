package web.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public interface ServiceLoginint {

	boolean LogIn(InputStream input) throws Exception;

	boolean LogInAmm(InputStream input) throws Exception;

}