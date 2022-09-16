package web.service;

import java.util.ArrayList;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.*;
import manager.UtenteManager;

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
public class WebServiceUtente implements Serviceutenteint {
	@Override
	@GET
	@Path("/WebServiceGet/Utenti")
	@Produces("application/json")
	public String ListaUtenti() {   //   LISTA DATI UTENTI
		
		String Result = null;
		try {
			ArrayList<Utente> Query = null;
			UtenteManager utman = new UtenteManager();
			Query= utman.ListaUtenti();
			
			ObjectMapper mapper = new ObjectMapper();
			Result = mapper.writeValueAsString(Query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/Registrazione")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Registrazione(InputStream input)throws Exception{
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
			
			String cf = (String) Jobj.get("cf");
			String nome = (String) Jobj.get("nome");
			String cognome = (String) Jobj.get("cognome");
			String email = (String) Jobj.get("email");
			String username = (String) Jobj.get("username");
			System.out.println(username);
			String password = (String) Jobj.get("password");
			UtenteManager utman = new UtenteManager();
			a = utman.Registrazione(cf,nome,cognome,email,username,password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/Elimina")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Elimina(InputStream input)throws Exception{
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
			
			String cf = (String) Jobj.get("cf");
			UtenteManager utman = new UtenteManager();
			a = utman.Eliminazione(cf);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	@Override
	@POST()
	@Path("/WebServicePost/ModUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ModUser(InputStream input)throws Exception{
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
			
			String username = (String) Jobj.get("username");
			String usernamev = (String) Jobj.get("usernamev");
			UtenteManager utman = new UtenteManager();
			a = utman.ModUser(username,usernamev);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/ModPass")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ModPass(InputStream input)throws Exception{
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
			
			String username = (String) Jobj.get("username");
			String password = (String) Jobj.get("password");
			UtenteManager utman = new UtenteManager();
			a = utman.ModPass(username,password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return Response.status(200).entity(a).build();
	}

}
