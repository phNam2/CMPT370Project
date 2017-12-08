package com.example.peter.myhome;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.NameValuePair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */

public class SearchResultActivity extends ListActivity {
    public static ProgressDialog pDialog;

    Search_JSONParser jParser = new Search_JSONParser();

    ArrayList<HashMap<String,String>> locationList;

    ////////input php location
    private static String url_location = "http://vidaviajera.tk/getdata.php";

    private static final String TAG_Street = "street";
    private static final String TAG_City = "city";
//    private static final String TAG_Country = "Country";
//    private static final String TAG_PostalCode = "PostalCode";

    JSONArray location = null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);

        locationList = new ArrayList<HashMap<String, String>>();

        new LoadLocation().execute();

  //      Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
     //   String place = bundle.getString(SearchActivity.textfile);

 //       ListView lv = getListView();

   //     lv.setOnItemClickListener(new onItemClickListener(){
   //         public void onItemClick(AdapterView<?> parent, View, view, int position, )
    //    });
    }


    class LoadLocation extends AsyncTask<String,String,String>{
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(SearchResultActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
 //           pDialog.dismiss();
        }

        protected String doInBackground(String...args){
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            String url_all_locat = "http://vidaviajera.tk/getdata.php";
            JSONObject json = jParser.makeHttpRequest(url_all_locat, "GET", params);
            Log.d("All Locations: ", json.toString());
            try{
                location = json.getJSONArray(TAG_Street);
                for (int a =0; a< location.length(); a++){
                    JSONObject c = location.getJSONObject(a);
                    String street = c.getString(TAG_Street);
                    String city = c.getString(TAG_City);
                    HashMap<String,String> map = new HashMap<String, String>();
                    map.put(TAG_City,city);
                    map.put(TAG_Street,street);
                    locationList.add(map);
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String file_url){
            pDialog.dismiss();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ListAdapter adapter = new SimpleAdapter(SearchResultActivity.this,locationList,R.layout.activity_search_list_item, new String[] { TAG_Street, TAG_City},
                            new int[] { R.id.street, R.id.city });
                    setListAdapter(adapter);
                }
            });
        }
    }
}


