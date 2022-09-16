package web.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.*;
import manager.LibreriaManager;
import manager.AnagraficaManager;

@Path("")
public class WebServiceAnagrafica {
	
	@POST()
	@Path("/WebServicePost/ModAna")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ModAna(InputStream input)throws Exception{
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
			
			
			String nome = (String) Jobj.get("nome");
			String cognome = (String) Jobj.get("cognome");
			String email = (String) Jobj.get("email");
			String username = (String) Jobj.get("username");
			AnagraficaManager ProMan = new AnagraficaManager();
			a = ProMan.ModAna(nome,cognome,email,username);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return Response.status(200).entity(a).build();
	}
	
	
	

}
