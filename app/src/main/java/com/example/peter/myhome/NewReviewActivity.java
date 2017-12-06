package com.example.peter.myhome;

/**
 * Created by Monika on 2017-12-01.
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewReviewActivity extends Activity {

    // Progress Dialog
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText inputPropertyID;
    EditText inputReviewContent;
    EditText inputRating;
    String tid = "1";

    // url to create new product
    private static String url_create_review = "http://vidaviajera.tk/create_review.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review);

        // Edit Text
        inputPropertyID = (EditText) findViewById(R.id.inputPropertyID);
        inputReviewContent = (EditText) findViewById(R.id.inputReviewContent);
        inputRating = (EditText) findViewById(R.id.inputRating);

        // Create button
        Button btnCreateReview = (Button) findViewById(R.id.btnCreateReview);

        // button click event
        btnCreateReview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new review in background thread
                new CreateNewReview().execute();
            }
        });
    }

    /**
     * Background Async Task to Create new review
     * */
    class CreateNewReview extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(NewReviewActivity.this);
            pDialog.setMessage("Creating Review..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating review
         * */
        protected String doInBackground(String... args) {
            String pid = inputPropertyID.getText().toString();
            String review = inputReviewContent.getText().toString();
            String rating = inputRating.getText().toString();

            Log.d("pid", "property"+pid);
            Log.d("review", "reviewText"+review);
            Log.d("rating", "rating"+rating);
            Log.d("tid", "tid"+tid);


            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("pid", pid));
            params.add(new BasicNameValuePair("review", review));
            params.add(new BasicNameValuePair("rating", rating));
            params.add(new BasicNameValuePair("tid", tid));
            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_create_review,
                    "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created review
                    Intent i = new Intent(getApplicationContext(), AllReviewsActivity.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create review
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}