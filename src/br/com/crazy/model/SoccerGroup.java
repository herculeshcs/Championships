package br.com.crazy.model;

public class SoccerGroup {
	private int Id;
	private int champId;
	private int number;
	private int numberOfTeams;
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	
	
}
