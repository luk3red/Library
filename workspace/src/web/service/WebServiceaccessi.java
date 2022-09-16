package web.service;




import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.*;

import manager.accessiManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;

@Path("")
public class WebServiceaccessi implements Serviceaccessiint {
	@Override
	@POST()
	@Path("/WebServicePost/Permesso")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Permesso(InputStream input)throws Exception{
		StringBuilder Sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(input));    //Prende lo stream input in ingresso
		try {
			String string = null;
			while((string = in.readLine()) != null)
				Sb.append(string);
		}catch(Exception e) {
				System.out.println(" ERRORE ");
		}
		//PARSE DEL JSON
		String  a = null;
		JSONParser jP = new JSONParser();
		try {
			Object obj =  jP.parse(Sb.toString());
			JSONObject Jobj = (JSONObject) obj;
			
			String ID_utente = (String) Jobj.get("ID_utente");
			String ID_owner = (String) Jobj.get("ID_owner");
			String ID_libreria = (String) Jobj.get("ID_libreria");
			accessiManager acman = new accessiManager();
			a = acman.Permesso(ID_utente,ID_owner,ID_libreria);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}

}
