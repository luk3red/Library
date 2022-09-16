package DTO;

import java.util.Date;

public class Proprietà {
	//private String Path;
	private String Nome;
	private String Cognome;
	private Date DATA;
	private int Dimensione;
	
	/*public String getPath() {
		return Path;
	}
	//public void setPath(String path) {
		Path = path;
	}*/
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public int getDimensione() {
		return Dimensione;
	}
	public void setDimensione(int dimensione) {
		this.Dimensione = dimensione;
	}
	public Date getDATA() {
		return DATA;
	}
	public void setDATA(Date dATA) {
		DATA = dATA;
	}
}
