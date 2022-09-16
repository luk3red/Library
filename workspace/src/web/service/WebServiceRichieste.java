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
import DAO.*;
import manager.*;

@Path("")
public class WebServiceRichieste implements Servicerichiesteint {
	
	@Override
	@POST()
	@Path("/WebServicePost/Richiedi")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Richiedi(InputStream input)throws Exception{
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
			
			String ID_libreria = (String) Jobj.get("ID_libreria");
			String username = (String) Jobj.get("username");
			RichiesteManager ProMan = new RichiesteManager();
			a = ProMan.Richiedi(username,ID_libreria);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@GET
	@Path("/WebServiceGet/Richieste/{username}")
	@Produces("application/json")
	public String ListaRichieste(@PathParam("username") String username) {
		String Result  = null;
		try {
			ArrayList<Richieste> Query = null;
			RichiesteManager ProMan = new RichiesteManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.ListaRichieste(username);
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	
	
	

}
