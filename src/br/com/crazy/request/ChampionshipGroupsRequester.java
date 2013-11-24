package br.com.crazy.request;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import br.com.crazy.model.SoccerChamp;

import com.google.gson.Gson;

import android.os.AsyncTask;
import android.util.Log;

public class ChampionshipGroupsRequester extends AsyncTask<String,Void, String> {

	GroupsFromChampListener l;
	public ChampionshipGroupsRequester( GroupsFromChampListener l) {
		this.l = l;
		// TODO Auto-generated constructor stub
	}
	
	String request(String url,String id){
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		try
		{
			List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("queryName","Groups_From_Champ"));
			nameValuePairs.add(new BasicNameValuePair("objectId",id));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                // send the variable and value, in other words post, to the URL
			
			 ResponseHandler<String> responseHandler=new BasicResponseHandler();
		     String responseBody = httpclient.execute(httppost, responseHandler);
			//HttpResponse response = httpclient.execute(httppost);
		     Gson json = new Gson();
		     
		   //SoccerChamp champ =json.fromJson(responseBody, SoccerChamp.class);
		     Log.i("peguei",responseBody);
		     
		return responseBody;
		}
		catch(Exception e)
		{
			Log.i("deu pau",e.getMessage());
		}
		return "";
	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		return request(params[0],params[1]);

	}
	
	protected void onPostExecute(String json){
		l.getGroupsFromRest(json);
	}
	public interface GroupsFromChampListener
	{
		public void getGroupsFromRest(String json);
	}
	
}
