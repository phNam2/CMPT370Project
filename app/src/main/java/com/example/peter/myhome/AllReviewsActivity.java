package com.example.peter.myhome;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;


public class AllReviewsActivity extends ListActivity {
    // Progress Dialog

    private ProgressDialog pDialog;

    // Creating JSON Parser object

    JSONParser jParser = new JSONParser();


    ArrayList<HashMap<String, String>> reviewsList;
    // url to get all reviews list

    private static final String TAG_SUCCESS = "success";

    private static final String TAG_REVIEWS = "reviews";

    private static final String TAG_RID = "review_id"; // the primary key in review table (the key in hashmap to)

    private static final String TAG_PROPERTY_ID = "property_id";

    private static final String TAG_REVIEW_CONTENT = "review_content";

    // reviews JSONArray

    JSONArray reviews = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_reviews);

        // Hashmap for ListView
        reviewsList = new ArrayList<>();

        // Loading products in Background Thread
        new LoadAllReviews().execute();

        // Get listview
        ListView lv = getListView();

        // on seleting single review
        // launching Edit Review Screen
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String rid = ((TextView) view.findViewById(R.id.rid)).getText().toString();
                // Starting new intent
                Intent in = new Intent(getApplicationContext(), EditReviewActivity.class);
                // sending pid to next activity
                in.putExtra(TAG_RID, rid);

                // starting new activity and expecting some response back
                startActivityForResult(in, 100);
            }
        });
    }
// Response from Edit Review Activity

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 200
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted review
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

    /**
     *      * Background Async Task to Load all product by making HTTP Request
     *      *
     */


    class LoadAllReviews extends AsyncTask<String, String, String> {
        /**
         *          * Before starting background thread Show Progress Dialog
         *          *
         */

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AllReviewsActivity.this);
            pDialog.setMessage("Loading reviews from history. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        //getting All reviews from url

        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            String url_all_reviews = "https://vidaviajera.000webhostapp.com/php/get_all_reviews.php";
            JSONObject json = jParser.makeHttpRequest(url_all_reviews, "GET", params);

            // Check your log cat for JSON reponse
            Log.d("All Reviews: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Reviews
                    reviews = json.getJSONArray(TAG_REVIEWS);
                    // looping through All Reviews
                    for (int i = 0; i < reviews.length(); i++) {
                        JSONObject c = reviews.getJSONObject(i);
                        // Storing each json item in variable
                        String id = c.getString(TAG_RID);
                        String property_id = c.getString(TAG_PROPERTY_ID);
                        String review_content = c.getString(TAG_REVIEW_CONTENT);
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        map.put(TAG_RID, id);
                        map.put(TAG_REVIEW_CONTENT,review_content);

                        // adding HashList to ArrayList
                        reviewsList.add(map);
                    }
                } else {
                    // no reviews found
                    // Launch Add New Review Activity
                    Intent i = new Intent(getApplicationContext(), NewReviewActivity.class);
                    // Closing all previous activities
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

//After completing background task Dismiss the progress dialog


        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all reviews
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {

                public void run() {
                    // Updating parsed JSON data into ListView

                    ListAdapter adapter =
                            new SimpleAdapter(AllReviewsActivity.this, reviewsList, R.layout.list_item, new String[]{TAG_RID, TAG_REVIEW_CONTENT},
                                    new int[]{R.id.rid, R.id.name});
                    // updating listview
                     setListAdapter(adapter);
                }
            });
        }
    }
}