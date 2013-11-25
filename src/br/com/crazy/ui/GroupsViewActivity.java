package br.com.crazy.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.br.crazy.R;
import br.com.crazy.model.SoccerGroup;
import br.com.crazy.request.GroupsTeamRequester;
import br.com.crazy.request.GroupsTeamRequester.GroupTeamsListener;
import br.com.crazy.utils.Constantes;

import com.google.gson.Gson;

public class GroupsViewActivity extends ListActivity implements GroupTeamsListener {

	List<SoccerGroup> listSoccerGroup;
	HashMap<String,Integer> idMap;
	private static int count;
	private Gson json;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_championships);
		Log.i("PP",getIntent().getStringExtra("jsonGroups"));
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<ArrayList<SoccerGroup>>() {}.getType();
		 json = new Gson();
		 idMap = new HashMap<String, Integer>();
		 List<String> strings =new  ArrayList<String>();
		listSoccerGroup = json.fromJson(getIntent().getStringExtra("jsonGroups"), type);
		for(int i=0;i<listSoccerGroup.size();i++)
		{
			strings.add(String.valueOf("Grupo 	"+this.listSoccerGroup.get(i).getNumber()));
			idMap.put("Grupo 	"+this.listSoccerGroup.get(i).getNumber(), this.listSoccerGroup.get(i).getId());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
		setListAdapter(adapter);
		count =0;
		Log.i("PP",listSoccerGroup.toString());
		//listStrings.add("bla");
		
	}
		
	 protected void onListItemClick(ListView l, View v, int position, long id) {
         
         super.onListItemClick(l, v, position, id);
         
          String  itemValue    = (String) l.getItemAtPosition(position);
          int groupId =  idMap.get(itemValue);
          new GroupsTeamRequester(this).execute(Constantes.QUERYURL,String.valueOf(groupId));
         // new ChampionshipGroupsRequester(this).execute(urlGroups,String.valueOf(listChampionship.get(itemValue).getId()));
         // Log.i("P",listChampionship.get(itemValue).getName());
          
            
     }

	@Override
	public void getTeams(String json) {
		
		Intent intent = new Intent(GroupsViewActivity.this,TeamGroupsViewActivity.class);
		intent.putExtra("jsonTeamGroups", json);
		startActivity(intent);
	}
}
