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
import manager.*;
import DTO.*;

@Path("")
public class WebServiceUtenteCond {

	@GET
	@Path("/WebServiceGet/UtentiCond/{IDC}")
	@Produces("application/json")
	public String ListaUtentiCond(@PathParam("IDC") String IDC) {   //   LISTA DATI UTENTI
		
		String Result = null;
		try {
			ArrayList<UtenteCond> Query = null;
			UtenteCondManager ProMan = new UtenteCondManager();
			Query= ProMan.ListaUserCond(IDC);
			
			ObjectMapper mapper = new ObjectMapper();
			Result = mapper.writeValueAsString(Query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@POST()
	@Path("/WebServicePost/AggALibCond")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AggALibCond(InputStream input)throws Exception{
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
			
			String username = (String) Jobj.get("username1");
			String idc = (String) Jobj.get("idc");
			String owner= (String) Jobj.get("username");
			UtenteCondManager ProMan = new UtenteCondManager();
			a = ProMan.AggALibCond(username,idc,owner);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@POST()
	@Path("/WebServicePost/Assegna")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Assegna(InputStream input)throws Exception{
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
			
			String uid = (String) Jobj.get("username1");
			String idc = (String) Jobj.get("idc");
			String owner = (String) Jobj.get("username");
			UtenteCondManager ProMan = new UtenteCondManager();
			a = ProMan.Assegna(uid,idc,owner);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
}
