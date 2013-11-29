package br.com.crazy.model;

public class SoccerPlayoffTeam {
	private int Id;
	private int playoffId;
	private int teamId;
	private int position;
	private String teamName;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getPlayoffId() {
		return playoffId;
	}
	public void setPlayoffId(int playoffId) {
		this.playoffId = playoffId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
}
