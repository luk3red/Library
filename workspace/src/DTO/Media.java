package DTO;

public class Media {
	
	private int ID;
	private int COD_LIB;
	private String Nome;
	private String Formato;
	private int OID; //owner id
	
	private Proprietā Proprietā;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getOID() {
		return OID;
	}
	public void setOID(int oiD) {
		OID = oiD;
	}
	public int COD_LIB() {
		return COD_LIB;
	}
	public void setCOD_LIB(int cOD_LIB) {
		COD_LIB = cOD_LIB;
	}
	public Proprietā getProprietā() {
		return Proprietā;
	}
	public void setProprietā(Proprietā proprietā) {
		Proprietā = proprietā;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getFormato() {
		return Formato;
	}
	public void setFormato(String Formato) {
		this.Formato = Formato;
	}
}
