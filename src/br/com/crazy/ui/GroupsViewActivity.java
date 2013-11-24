package br.com.crazy.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import br.com.crazy.model.SoccerGroup;


import com.br.crazy.R;
import com.google.gson.Gson;

public class GroupsViewActivity extends ListActivity{

	List<SoccerGroup> listSoccerGroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_championships);
		Log.i("PP",getIntent().getStringExtra("jsonGroups"));
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<ArrayList<SoccerGroup>>() {}.getType();
		Gson json = new Gson();
		listSoccerGroup = json.fromJson(getIntent().getStringExtra("jsonGroups"), type);
		
		Log.i("PP",listSoccerGroup.toString());
		
		//listStrings.add("bla");
		
	}
}
