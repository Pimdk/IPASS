package pim.hu.IPASS.domain;

public class Team {
	private String teamID;
	private String leefdtijdsklasse;
	private String klasse;
	private String naam;
	private Competitie inCompetitie;
	
	public Team(String tid, String lk, String kl, String na){
		this.teamID = tid;
		this.leefdtijdsklasse = lk;
		this.klasse = kl;
		this.naam = na;
	}
	public String getLeefdtijdsklasse() {
		return leefdtijdsklasse;
	}
	public void setLeefdtijdsklasse(String leefdtijdsklasse) {
		this.leefdtijdsklasse = leefdtijdsklasse;
	}
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getKlasse() {
		return klasse;
	}
	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	
	
	
}
