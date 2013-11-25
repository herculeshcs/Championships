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


import com.google.gson.Gson;

public class TeamGroupsViewActivity extends Activity implements View.OnClickListener,
OnTouchListener{
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	List<SoccerGroupTeam> listTeam;
	int team;
	int size;
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<ArrayList<SoccerGroupTeam>>() {}.getType();
		Gson json = new Gson();
		team=0;
		listTeam = json.fromJson(getIntent().getStringExtra("jsonTeamGroups"), type);
		setContentView(R.layout.team_layout);
		setLayout(listTeam.get(0));
		
		Log.i("bla",listTeam.get(0).toString());
		size=listTeam.size();
		
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
						team = (team+1)%size;
						setLayout(listTeam.get(team));
					}
				 else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					 
						team = (team+1)%size;
						setLayout(listTeam.get(team));
					}


			return false;
		}
	}

	
}
