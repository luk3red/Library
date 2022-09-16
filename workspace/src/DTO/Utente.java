package DTO;

public class Utente {

	private int UID;
	private String COD_FISC;
	private String Username;
	private String Password;
	private Byte Permessi;
	
	private Anagrafica Anagrafica;
	
	
	
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
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
	
	
	public Anagrafica getAnagrafica() {
		return Anagrafica;
	}
	public void setAnagrafica(Anagrafica anagrafica) {
		Anagrafica = anagrafica;
	}
	public String getCOD_FISC() {
		return COD_FISC;
	}
	public void setCOD_FISC(String cOD_FISC) {
		COD_FISC = cOD_FISC;
	}
	public Byte getPermessi() {
		return Permessi;
	}
	public void setPermessi(Byte permessi) {
		Permessi = permessi;
	}
	

}
