package br.com.crazy.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.crazy.model.SoccerChamp;
import br.com.crazy.request.ChampionshipGroupsRequester;
import br.com.crazy.request.ChampionshipGroupsRequester.GroupsFromChampListener;
import br.com.crazy.request.ChampionshipRequester;
import br.com.crazy.request.ChampionshipRequester.ChampionshipListener;

import com.br.crazy.R;
import com.google.gson.Gson;

public class ChampionshipsActivity extends ListActivity implements ChampionshipListener,GroupsFromChampListener{

	private final String url = "http://192.168.1.107:80/webservice/api.php?action=getObject";
	private final String urlGroups = "http://192.168.1.107:80/webservice/api.php?action=getQuery";
	private HashMap<String,SoccerChamp> listChampionship;
	private List<String> listStrings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new ChampionshipRequester(this).execute(url);
		listStrings = new ArrayList<String>();
		listChampionship = new HashMap<String,SoccerChamp>();
		setContentView(R.layout.activity_championships);	
		//listStrings.add("bla");
		
	 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.championships, menu);
		return true;
	}
	@Override
	public void listChampionShip(String json) {
		Gson j = new Gson();
		SoccerChamp champ = j.fromJson(json, SoccerChamp.class);
		listChampionship.put(champ.getName(),champ);
		listStrings.add(champ.getName());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listStrings);
	    setListAdapter(adapter);
	     
		}
	 protected void onListItemClick(ListView l, View v, int position, long id) {
         
         super.onListItemClick(l, v, position, id);
         
                    // ListView Clicked item index
         	
            // ListView Clicked item value
          String  itemValue    = (String) l.getItemAtPosition(position);
          new ChampionshipGroupsRequester(this).execute(urlGroups,String.valueOf(listChampionship.get(itemValue).getId()));
          Log.i("P",listChampionship.get(itemValue).getName());
          
            
     }
	@Override
	public void getGroupsFromRest(String json) {
		// TODO Auto-generated method stub
		Log.i("Grupos",json);
		Intent intent = new Intent(ChampionshipsActivity.this,GroupsViewActivity.class);
		intent.putExtra("jsonGroups", json);
		startActivity(intent);
	}
	
}
