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

public class MatchResquester extends AsyncTask<String, Void, String> {

	MatchListener l;
	
	public MatchResquester( MatchListener l) {
		this.l = l;
		// TODO Auto-generated constructor stub
	}
	String request(String url,String id){
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		try
		{
			List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("queryName","Matchs_From_Playoff"));
			nameValuePairs.add(new BasicNameValuePair("objectId",id));
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
	@Override
	protected String doInBackground(String... params) {
		
		return request(params[0],params[1]);
	}
	protected void onPostExecute(String json){
		l.getMatch(json);
	}
	public interface MatchListener{
		public void getMatch(String json);
	}
}
