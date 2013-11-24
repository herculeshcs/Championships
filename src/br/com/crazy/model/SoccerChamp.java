package br.com.crazy.model;

public class SoccerChamp {
	private int Id;
	private String name;
	private int numberOfGroups;
	private int numberOfTeams;
	private int playoffTeam;
	private int userId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfGroups() {
		return numberOfGroups;
	}
	public void setNumberOfGroups(int numberOfGroups) {
		this.numberOfGroups = numberOfGroups;
	}
	public int getPlayoffTeam() {
		return playoffTeam;
	}
	public void setPlayoffTeam(int playoffTeam) {
		this.playoffTeam = playoffTeam;
	}
	public int getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
