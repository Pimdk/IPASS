package pim.hu.IPASS.domain;

public class Competitie {
	private String competitieID;
	private String naam;
	private String jaar;
	
	public Competitie(String cid, String na, String ja){
		this.competitieID = cid;
		this.naam = na;
		this.jaar = ja;
	}
	
	public String getCompetitieID() {
		return competitieID;
	}
	public void setCompetitieID(String competitieID) {
		this.competitieID = competitieID;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getJaar() {
		return jaar;
	}
	public void setJaar(String jaar) {
		this.jaar = jaar;
	}
	
	
	
	
	
	
}
