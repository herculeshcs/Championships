package com.br.crazy.model;

import java.util.List;

public class Championship {
	private List<Team> teamList;
	private String name;
	private int numberTeam;
	
	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		teamList = teamList;
	}

	public int getNumberTeam() {
		return teamList.size();
	}

	public void setNumberTeam(int numberTeam) {
		this.numberTeam = numberTeam;
	}
	
}
