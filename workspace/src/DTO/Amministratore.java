package DTO;

public class Amministratore {
	
	private int SID;
	private String Username;
	private String Password;
	private String COD_FISC;
	
	private Anagrafica Anagrafica;
	
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCOD_FISC() {
		return COD_FISC;
	}
	public void setCOD_FISC(String cOD_FISC) {
		COD_FISC = cOD_FISC;
	}
	public Anagrafica getAnagrafica() {
		return Anagrafica;
	}
	public void setAnagrafica(Anagrafica anagrafica) {
		Anagrafica = anagrafica;
	}
	
	

}
