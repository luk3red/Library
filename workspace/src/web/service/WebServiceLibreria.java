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

@Path("")
public class WebServiceLibreria implements Servicelibreriaint {
	
	@Override
	@GET
	@Path("/WebServiceGet/Librerie")
	@Produces("application/json")
	public String ListaLibrerie() {   //   LISTA PROGETTI UTENTI
		
		String Result = null;
		try {
			ArrayList<Libreria> Query = null;
			LibreriaManager ProMan = new LibreriaManager();
			Query= ProMan.ListaLibreria();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  	
			ObjectMapper mapper = new ObjectMapper();
			Result = mapper.writeValueAsString(Query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@Override
	@GET
	@Path("/WebServiceGet/libpubb/")
	@Produces("application/json")
	public String ListaLibpubb() {           // LISTA DEI PROGETTI PUBBLICI
		String Result  = null;
		try {
			ArrayList<Libreria> Query = null;
			LibreriaManager ProMan = new LibreriaManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.ListaLibpubb();
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	

	@Override
	@GET
	@Path("/WebServiceGet/Libreriapubblica/{id_libreria}" + "/{username}")
	@Produces("application/json")
	public String LibPub(@PathParam("id_libreria") String id_libreria, @PathParam("username") String username) {
		String Result  = null;
		try {
			ArrayList<Media> Query = null;
			LibreriaManager ProMan = new LibreriaManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.LibPub(id_libreria,username);
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/CreaLib")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreaLib(InputStream input)throws Exception{
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
			String nomelibreria = (String) Jobj.get("nomelibreria");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.CreaLib(username,nomelibreria);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/CreaLibCond")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreaLibCond(InputStream input)throws Exception{
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
			String nomelibreria = (String) Jobj.get("nomelibreria");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.CreaLibCond(username,nomelibreria);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/EliminaLib")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EliminaLib(InputStream input)throws Exception{
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
			
			String id = (String) Jobj.get("id");
			String username = (String) Jobj.get("username");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.EliminaLib(id,username);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/Modnomelib")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Modnomelib(InputStream input)throws Exception{
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
			String idlib = (String) Jobj.get("idlib");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.Modnomelib(nome,idlib);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/Modnomelibc")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Modnomelibc(InputStream input)throws Exception{
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
			String idlib = (String) Jobj.get("idlib");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.Modnomelibc(nome,idlib);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	
	@Override
	@POST()
	@Path("/WebServicePost/PubLib")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response PubLib(InputStream input)throws Exception{
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
			
			String idlib = (String) Jobj.get("idlib");
			String username = (String) Jobj.get("username");
			LibreriaManager ProMan = new LibreriaManager();
			a = ProMan.PubLib(idlib, username);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@GET
	@Path("/WebServiceGet/UserP/{Username}")
	@Produces("application/json")
	public String ListaLibreriaUser(@PathParam("Username") String username) {           // LISTA DEI PROGETTI DI UN CERTO UTENTE
		String Result  = null;
		try {
			ArrayList<Libreria> Query = null;
			LibreriaManager ProMan = new LibreriaManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.ListaLibreriaUser(username);
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@Override
	@GET
	@Path("/WebServiceGet/UserPC/{Username}")
	@Produces("application/json")
	public String ListaLibreriaCUser(@PathParam("Username") String username) {           // LISTA DEI PROGETTI DI UN CERTO UTENTE
		String Result  = null;
		try {
			ArrayList<Libreria> Query = null;
			LibreriaManager ProMan = new LibreriaManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.ListaLibreriaCUser(username);
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	@Override
	@GET
	@Path("/WebServiceGet/UserPCw/{Username}")
	@Produces("application/json")
	public String ListaLibreriaCwUser(@PathParam("Username") String username) {           // LISTA DEI PROGETTI DI UN CERTO UTENTE
		String Result  = null;
		try {
			ArrayList<Libreria> Query = null;
			LibreriaManager ProMan = new LibreriaManager();    //INVOCA IL PROJECT MANAGER
			Query= ProMan.ListaLibreriaCwUser(username);
			
			ObjectMapper mapper = new ObjectMapper();         // SCRIVI IN JSON
			Result = mapper.writeValueAsString(Query);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return Result;
	}
	
	
	
	
	

}
