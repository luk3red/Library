package DTO;

public class Libreria {
	
	private int ID;
	private int ID_AMM;
	private int ID_User;
	private Byte Privacy;
	private String Nome;
	
	private Proprietā Proprietā;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID_AMM() {
		return ID_AMM;
	}
	public void setID_AMM(int iD_AMM) {
		ID_AMM = iD_AMM;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
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
	public Byte getPrivacy() {
		return Privacy;
	}
	public void setPrivacy(Byte privacy) {
		Privacy = privacy;
	}

}
