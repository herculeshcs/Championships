package br.com.crazy.ui;

import java.util.List;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import br.com.crazy.model.SoccerChamp;
import br.com.crazy.model.ChampionshipRequester;

import com.br.crazy.R;

public class ChampionshipsActivity extends ListActivity implements OnClickListener{

	private final String url = "http://192.168.1.103:80/webservice/api.php?action=getObject";
	private List<SoccerChamp> ListChampionship;
	   String[] listItems = {"agora", "fica mais facil", 
               "lala", "paçocas tem o poder"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new ChampionshipRequester().execute(url);
			/*  setListAdapter(new ArrayAdapter(this, 
		              android.R.layout.simple_list_item_1, listItems));
		     
		}*/
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.championships, menu);
		return true;
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
