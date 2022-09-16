package DTO;

public class Richieste {
	private int ID_richiedente;
	private int ID_libreria;
	private int ID_owner;
	private int ID;

	
	public void setID_richiedente(int ID_richiedente) {
		this.ID_richiedente=ID_richiedente;
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
		return ID_richiedente;
	}
	public int getID_libreria() {
		return ID_libreria;
	}
	public int getID_owner() {
		return ID_owner;
	}
	
}
