package br.com.crazy.model;

public class SoccerChampTeam {
	private int Id;
	private int idChamp;
	private int idTeam;
	private int points;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdChamp() {
		return idChamp;
	}
	public void setIdChamp(int idChamp) {
		this.idChamp = idChamp;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
