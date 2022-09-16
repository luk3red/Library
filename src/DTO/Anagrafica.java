package DTO;


public class Anagrafica {
	
	public Anagrafica(String CF, String Nome, String Cognome, String Email) {
		this.CF=CF;
		this.Nome=Nome;
		this.Cognome=Cognome;
		this.Email=Email;
	}
	
	private String CF;
	private String Nome;
	private String Cognome;
	private String Email;
	
	public String getCF() {
		return CF;
	}
	public void setCF(String CF) {
		this.CF = CF;
	}
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
