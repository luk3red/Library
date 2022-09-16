package DTO;

public class accessi {
	private int ID;
	private int ID_utente;
	private int ID_owner;
	private int ID_libreria;

	
	public void setID_utente(int ID_utente) {
		this.ID_utente=ID_utente;
	}
	public void setID_libreria(int ID_libreria) {
		this.ID_libreria=ID_libreria;
	}
	public void setID_owner(int ID_owner) {
		this.ID_owner=ID_owner;
	}
	public void setID(int ID) {
		this.ID=ID;
	}

	public int getID() {
		return ID;
	}
	public int getID_richiedente() {
		return ID_utente;
	}
	public int getID_libreria() {
		return ID_libreria;
	}
	public int getID_owner() {
		return ID_owner;
	}
	
}
