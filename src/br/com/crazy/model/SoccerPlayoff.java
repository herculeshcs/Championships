package br.com.crazy.model;

public class SoccerPlayoff {
	private int Id;
	private int champId;
	private int numberOfTeams;
	private int roundOf;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getChampId() {
		return champId;
	}
	public void setChampId(int champId) {
		this.champId = champId;
	}
	public int getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	public int getRoundOf() {
		return roundOf;
	}
	public void setRoundOf(int roundOf) {
		this.roundOf = roundOf;
	}
	
	
}
