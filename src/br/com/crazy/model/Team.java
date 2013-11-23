package br.com.crazy.model;

import java.util.List;

public class Team {
	private String name;
	private List<Player> PlayerList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getPlayerList() {
		return PlayerList;
	}
	public void setPlayerList(List<Player> playerList) {
		PlayerList = playerList;
	}
	
	

}
