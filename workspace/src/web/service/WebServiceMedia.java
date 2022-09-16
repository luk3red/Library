package web.service;

import java.util.ArrayList;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.*;
import manager.MediaManager;

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
public class WebServiceMedia implements Servicemediaint {
	
	@Override
	@GET
	@Path("/WebServiceGet/Media/{id}" + "/{username}")
	@Produces("application/json")
	public String ListaMediaLib(@PathParam("id") String id, @PathParam("username") String username) {
		String Result  = null;
		try {
			ArrayList<Media> Query = null;
			MediaManager medman = new MediaManager();    //INVOCA IL PROJECT MANAGER
			Query= medman.ListaMediaLib(id,username);
			
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
	@Path("/WebServiceGet/Mediac/{id}" + "/{username}")
	@Produces("application/json")
	public String ListaMediaLibC(@PathParam("id") String id, @PathParam("username") String username) {
		String Result  = null;
		try {
			ArrayList<Media> Query = null;
			MediaManager medman = new MediaManager();    //INVOCA IL PROJECT MANAGER
			Query= medman.ListaMediaLibC(id,username);
			
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
			MediaManager medman = new MediaManager();    //INVOCA IL PROJECT MANAGER
			Query= medman.LibPub(id_libreria,username);
			
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
	@Path("/WebServicePost/ModMedia")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ModMedia(InputStream input)throws Exception{
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
			
			String id_media = (String) Jobj.get("id_media");
			String idlib = (String) Jobj.get("idlib");
			MediaManager medman = new MediaManager();
			a = medman.ModMedia(id_media,idlib);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/CreaMedia")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreaMedia(InputStream input)throws Exception{
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
			String formato = (String) Jobj.get("formato");
			String id = (String) Jobj.get("id");
			String username = (String) Jobj.get("username");
			MediaManager medman = new MediaManager();
			a = medman.CreaMedia(nome,formato,id,username);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	@Override
	@POST()
	@Path("/WebServicePost/CreaMediaC")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreaMediaC(InputStream input)throws Exception{
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
			String formato = (String) Jobj.get("formato");
			String id = (String) Jobj.get("id");
			String username = (String) Jobj.get("username");
			MediaManager medman = new MediaManager();
			a = medman.CreaMediaC(nome,formato,id,username);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	@Override
	@POST()
	@Path("/WebServicePost/EliminaMedia")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EliminaMedia(InputStream input)throws Exception{
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
			
			String id = (String) Jobj.get("id_media");
			String idlib = (String) Jobj.get("idlib");
			MediaManager medman = new MediaManager();
			a = medman.EliminaMedia(id,idlib);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/EliminaMediaC")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EliminaMediaC(InputStream input)throws Exception{
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
			
			String id = (String) Jobj.get("id_media");
			String idlib = (String) Jobj.get("idlib");
			MediaManager medman = new MediaManager();
			a = medman.EliminaMediaC(id,idlib);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
		return Response.status(200).entity(a).build();
	}
	
	

}
