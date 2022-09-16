package DTO;

public class Prestito {
	private int ID;
	private int IDM;
	private int UID;
	private int IDB;
	private String date;
	private String exdate;
	
	public void setID(int ID) {
		this.ID=ID;
	}
	public void setUID(int UID) {
		this.UID=UID;
	}
	public void setIDB(int IDB) {
		this.IDB=IDB;
	}
	public void setIDM(int IDM) {
		this.IDM=IDM;
	}
	public void setDATE(String date) {
		this.date=date;	
	}
	public void setEXDATE(String exdate) {
		this.exdate=exdate;
	}
	public int getID() {
		return ID;
	}
	public int getUID() {
		return UID;
	}
	public int getIDM() {
		return IDM;
	}
	public int getIDB() {
		return IDB;
	}
	public String getDATE() {
		return date;
	}
	public String getEXDATE() {
		return exdate;	
	}
}
