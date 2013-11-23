package br.com.crazy.model;

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

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class ChampionshipRequester extends AsyncTask<String,String,Void> {
	private HttpRequest httpRequest;
	void request (String url)
	{
			
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		try
		{
			List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("objectName","SoccerChamp"));
			nameValuePairs.add(new BasicNameValuePair("objectId","1"));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                // send the variable and value, in other words post, to the URL
			
			 ResponseHandler<String> responseHandler=new BasicResponseHandler();
		     String responseBody = httpclient.execute(httppost, responseHandler);
			//HttpResponse response = httpclient.execute(httppost);
		     Gson json = new Gson();
		     
		   SoccerChamp champ =json.fromJson(responseBody, SoccerChamp.class);
		     
			Log.i("peguei",responseBody);
			Log.i("peguei",champ.getName());
		}
		catch(Exception e)
		{
			Log.i("deu pau",e.getMessage());
		}
		
	}
	protected Void doInBackground(String...strings ) {
		
		request(strings[0]);
		return null;
	}

}
