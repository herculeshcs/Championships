package br.com.crazy.model;

public class SoccerMatch {
	private int Id;
	private int winnerId;
	private int state;
	private int groupId;
	private int playoffId;
	private int teamId1;
	private int teamId2;
	private int points1;
	private int points2;
	private String teamName1;
	private String teamName2;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getPlayoffId() {
		return playoffId;
	}
	public void setPlayoffId(int playoffId) {
		this.playoffId = playoffId;
	}
	public int getTeamId1() {
		return teamId1;
	}
	public void setTeamId1(int teamId1) {
		this.teamId1 = teamId1;
	}
	public int getTeamId2() {
		return teamId2;
	}
	public void setTeamId2(int teamId2) {
		this.teamId2 = teamId2;
	}
	public int getPoints1() {
		return points1;
	}
	public void setPoints1(int points1) {
		this.points1 = points1;
	}
	public int getPoints2() {
		return points2;
	}
	public void setPoints2(int points2) {
		this.points2 = points2;
	}
	public String getTeamName1() {
		return teamName1;
	}
	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}
	public String getTeamName2() {
		return teamName2;
	}
	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}
	
	
}
