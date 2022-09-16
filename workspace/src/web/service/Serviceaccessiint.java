package web.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Serviceaccessiint {

	Response Permesso(InputStream input) throws Exception;

}