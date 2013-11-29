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

import android.os.AsyncTask;
import android.util.Log;
import br.com.crazy.model.SoccerChamp;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class ChampionshipRequester extends AsyncTask<String,String,String> {
	private HttpRequest httpRequest;
	private ChampionshipListener l;
	  public ChampionshipRequester(ChampionshipListener l)
	  {
		  this.l = l;
	  }
	String request (String url)
	{
			
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		try
		{
			List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("queryName","Champs"));
			nameValuePairs.add(new BasicNameValuePair("objectId","1"));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                // send the variable and value, in other words post, to the URL
			
			 ResponseHandler<String> responseHandler=new BasicResponseHandler();
		     String responseBody = httpclient.execute(httppost, responseHandler);
			//HttpResponse response = httpclient.execute(httppost);
		     Log.i("peguei",responseBody);
		 
		     
		return responseBody;
		}
		catch(Exception e)
		{
			return null;
		}

	}
	
	protected void onPostExecute(String json)
	{
		l.listChampionShip(json);
	}
	protected String doInBackground(String...strings ) {
		
		return request(strings[0]);
	}
	
	public interface ChampionshipListener
	{
		public void listChampionShip(String json);
	}

}
