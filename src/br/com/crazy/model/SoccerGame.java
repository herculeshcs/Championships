package br.com.crazy.model;

public class SoccerGame {
	private int Id;
	private int winnerId;
	private int state;
	private int goals1;
	private int goals2;
	private int matchId;
	
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
	public int getGoals1() {
		return goals1;
	}
	public void setGoals1(int goals1) {
		this.goals1 = goals1;
	}
	public int getGoals2() {
		return goals2;
	}
	public void setGoals2(int goals2) {
		this.goals2 = goals2;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
}
