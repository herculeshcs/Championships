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
import com.br.crazy.R;
import br.com.crazy.model.SoccerChamp;
import br.com.crazy.model.SoccerGroup;
import br.com.crazy.request.ChampionshipGroupsRequester;
import br.com.crazy.request.ChampionshipGroupsRequester.GroupsFromChampListener;
import br.com.crazy.request.ChampionshipRequester;
import br.com.crazy.request.ChampionshipRequester.ChampionshipListener;
import br.com.crazy.utils.Constantes;

import com.google.gson.Gson;

public class ChampionshipsActivity extends ListActivity implements ChampionshipListener,GroupsFromChampListener{

	private final String url = "http://192.168.1.107:80/webservice/api.php?action=getObject";
	private final String urlGroups = "http://192.168.1.107:80/webservice/api.php?action=getQuery";
	private HashMap<String,SoccerChamp> listChampionship;
	private List<String> listStrings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new ChampionshipRequester(this).execute(Constantes.QUERYURL);
		listStrings = new ArrayList<String>();
		listChampionship = new HashMap<String,SoccerChamp>();
		setContentView(R.layout.activity_championships);	
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
			//SoccerChamp champ = j.fromJson(json, SoccerChamp.class);
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<ArrayList<SoccerChamp>>() {}.getType();
			List<SoccerChamp> champs  = j.fromJson(json, type);
			for(int i=0;i< champs.size();i++){
				listChampionship.put(champs.get(i).getName(),champs.get(i));
				listStrings.add(champs.get(i).getName());
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listStrings);
		    setListAdapter(adapter);
		}
	 protected void onListItemClick(ListView l, View v, int position, long id) {
         
         super.onListItemClick(l, v, position, id);
         
          String  itemValue    = (String) l.getItemAtPosition(position);
          new ChampionshipGroupsRequester(this).execute(Constantes.QUERYURL,String.valueOf(listChampionship.get(itemValue).getId()));
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
