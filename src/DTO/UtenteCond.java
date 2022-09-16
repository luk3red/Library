package DTO;

public class UtenteCond {

	private int ID_USER;
	private int IDC;
	private int Permesso;
	
	public int getUID() {
		return ID_USER;
	}
	
	public int getIDC() {
		return IDC;
	}
	
	public int getPermesso() {
		return Permesso;
	}
	
	public void setUID(int uID) {
		ID_USER = uID;
	}
	
	public void setIDC(int IDc) {
		IDC = IDc;
	}
	public void setPermesso(int Permesso) {
		this.Permesso = Permesso;
	}
	
}
