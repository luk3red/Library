package web.service;
import java.util.ArrayList;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.*;
import manager.UtenteManager;
import manager.AmministratoreManager;

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
public class WebServiceLogin implements ServiceLoginint {
	@Override
	@POST()
	@Path("/WebServicePost/LogIn")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean LogIn(InputStream input)throws Exception{
		boolean s = false;
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
		
		JSONParser jP = new JSONParser();
		try {
			Object obj =  jP.parse(Sb.toString());
			JSONObject Jobj = (JSONObject) obj;
			String username = (String) Jobj.get("username");
			String password = (String) Jobj.get("password");
			UtenteManager utman = new UtenteManager();
			s= utman.LogIn(username, password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}return s;
	
		
	}
	
	@Override
	@POST()
	@Path("/WebServicePost/LogInAmm")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean LogInAmm(InputStream input)throws Exception{
		boolean s = false;
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
		
		JSONParser jP = new JSONParser();
		try {
			Object obj =  jP.parse(Sb.toString());
			JSONObject Jobj = (JSONObject) obj;
			String username = (String) Jobj.get("username");
			String password = (String) Jobj.get("password");
			AmministratoreManager amman = new AmministratoreManager();
			s= amman.LogInAmm(username, password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}return s;
	
		
	}



}
