package br.com.crazy.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.br.crazy.R;
import br.com.crazy.model.SoccerGroupTeam;
import br.com.crazy.model.SoccerMatch;
import br.com.crazy.model.SoccerPlayoff;
import br.com.crazy.model.SoccerPlayoffTeam;


import com.google.gson.Gson;

public class TeamGroupsViewActivity extends Activity implements View.OnClickListener,
OnTouchListener{
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	List<SoccerGroupTeam> listTeam;
	List<SoccerMatch> listMatch;
	List<SoccerPlayoffTeam> listPlayoffTeams;
	int team;
	int size;
	int layout;
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		team=0;
		if(getIntent().getStringExtra("tipo").equals("Team"))
		{
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<ArrayList<SoccerGroupTeam>>() {}.getType();
			Gson json = new Gson();
	
			listTeam = json.fromJson(getIntent().getStringExtra("jsonTeamGroups"), type);
			setContentView(R.layout.team_layout);
			setLayout(listTeam.get(0));
		
			Log.i("bla",listTeam.get(0).toString());
			size=listTeam.size();
			layout=1;
		}
		else
		{
			java.lang.reflect.Type type1 = new com.google.gson.reflect.TypeToken<ArrayList<SoccerMatch>>() {}.getType();
			java.lang.reflect.Type type2 = new com.google.gson.reflect.TypeToken<ArrayList<SoccerPlayoffTeam>>() {}.getType();
			Gson json = new Gson();
			listTeam = json.fromJson(getIntent().getStringExtra("jsonTeam"), type2);
			listMatch = json.fromJson(getIntent().getStringExtra("jsonMatch"), type1);
			setContentView(R.layout.play_off_layout);
			size = listMatch.size();
			layout=0;
			
		}
		View principal = (View) findViewById(R.id.scroll_view);
		gestureDetector = new GestureDetector(this, new MyGestureDetector());
		gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};
		principal.setOnTouchListener(gestureListener);
		
	}
	void setLayout(SoccerGroupTeam team)
	{
	 setTextView(R.id.team_name,team.getTeamName());
	 
	 setTextView(R.id.quantidade_derrotas,String.valueOf(team.getDefeats()));
	 
	 setTextView(R.id.quantidade_empate,String.valueOf(team.getDraws()));
	 
	 setTextView(R.id.quantidade_pont,String.valueOf(team.getDraws()+team.getVictories()*3));
	 
	 setTextView(R.id.quantidade_saldo_gols,String.valueOf(team.getGoalsBalance()));
	 
	 setTextView(R.id.possicao,String.valueOf(team.getPosition()));

	 setTextView(R.id.quantidade_vitorias,String.valueOf(team.getPosition()));
	
	}
	void setMatchLayout(SoccerMatch match)
	{
		String name="";
		String name2="";
		for(int i =0;i < listTeam.size();i++)
		{
			if(listTeam.get(i).getId() == match.getTeamId1()){
				name = listTeam.get(i).getTeamName();
			}
			if(listTeam.get(i).getId() == match.getTeamId2()){
				name = listTeam.get(i).getTeamName();
			}
		}
		setTextView(R.id.team_name,name);
		setTextView(R.id.team_name2, name2);
		setTextView(R.id.quantidade_pont,String.valueOf( match.getPoints1()));
		setTextView(R.id.possicao,String.valueOf(match.getPoints2()));
	}
	void setTextView(int id, String text)
	{
		TextView t = (TextView) findViewById(id);
		 t.setText(text);
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
				if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
					return false;
				// right to left swipe
				if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
						if(layout==1)
						{
							team = (team+1)%size;
							setLayout(listTeam.get(team));
						}
						else
						{
							team= (team+1)%size;
							setMatchLayout(listMatch.get(team));
						}
					}
				 else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
			
						 && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					 	if(layout==1)
					 	{
					 		team = (team+1)%size;
					 		setLayout(listTeam.get(team));
					 	}
					 	else
						{
							team= (team+1)%size;
							setMatchLayout(listMatch.get(team));
						}
					}


			return false;
		}
	}

	
}
