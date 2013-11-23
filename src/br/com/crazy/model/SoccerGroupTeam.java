package br.com.crazy.model;

public class SoccerGroupTeam {
	private int Id;
	private int groupId;
	private int teamId;
	private int position;
	private int victories;
	private int defeats;
	private int draws;
	private int goalsBalance;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	public int getVictories() {
		return victories;
	}
	public void setVictories(int victories) {
		this.victories = victories;
	}
	public int getDefeats() {
		return defeats;
	}
	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getGoalsBalance() {
		return goalsBalance;
	}
	public void setGoalsBalance(int goalsBalance) {
		this.goalsBalance = goalsBalance;
	}
	
	
}
