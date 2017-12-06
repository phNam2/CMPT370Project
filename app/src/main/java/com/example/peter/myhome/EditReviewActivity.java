package com.example.peter.myhome;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.StrictMode;


public class EditReviewActivity extends Activity {

    EditText txtProperty_id;
    EditText txtReviewContent;
    EditText txtRating;
    EditText txtCreatedAt;
    Button btnSave;
    Button btnDelete;

    String rid;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    // single review url
    private static final String url_review_detials = "http://vidaviajera.tk/get_review_details.php";

    // url to update review
    private static final String url_update_review = "http://10.0.2.2/android_connect/update_product.php";

    // url to delete review
    private static final String url_delete_review = "http://10.0.2.2/android_connect/delete_product.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_REVIEWS = "review";
    private static final String TAG_RID = "review_id";
    private static final String TAG_PROPERTY_ID = "property_id";
    private static final String TAG_REVIEW_CONTENT = "review_content";

    private static final String TAG_RATING = "rating";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_review);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // save button
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        // getting review details from intent
        Intent i = getIntent();

        // getting review id (rid) from intent
        rid = i.getStringExtra(TAG_RID);

        // Getting complete review details in background thread
        new GetReviewDetails().execute();

        // save button click event
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // starting background task to update review
                new SaveReviewDetails().execute();
            }
        });

        // Delete button click event
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // deleting review in background thread
                new DeleteReview().execute();
            }
        });

    }

    /**
     * Background Async Task to Get complete review details
     */
    class GetReviewDetails extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditReviewActivity.this);
            pDialog.setMessage("Loading review details. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Getting review details in background thread
         */
        protected String doInBackground(String... params) {

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    // Check for success tag
                    int success;
                    try {
                        // Building Parameters
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("rid", rid));
                        Log.d("rid", "ouhdc"+rid);
                        // getting review details by making HTTP request
                        // Note that review details url will use GET request
                        JSONObject json = jsonParser.makeHttpRequest(
                                url_review_detials, "GET", params);

                        // check your log for json response
                        Log.d("Single Review Details", json.toString());

                        // json success tag
                        success = json.getInt(TAG_SUCCESS);
                        if (success == 1) {
                            // successfully received review details
                            JSONArray reviewObj = json
                                    .getJSONArray(TAG_REVIEWS); // JSON Array

                            // get first product object from JSON Array
                            JSONObject review = reviewObj.getJSONObject(0);

                            // review with this pid found
                            // Edit Text
                            txtProperty_id = (EditText) findViewById(R.id.inputPropertyId);
                            txtReviewContent = (EditText) findViewById(R.id.inputReviewContent);

                            txtRating = (EditText) findViewById(R.id.inputRating);
                            // display review data in EditText



                            txtProperty_id.setText(review.getString(TAG_PROPERTY_ID));
                            txtReviewContent.setText(review.getString(TAG_REVIEW_CONTENT));

                            txtRating.setText(review.getString(TAG_RATING));
                        } else {
                            // product with rid not found
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

            return null;
        }


        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once got all details
            pDialog.dismiss();
        }
    }

    /**
     * Background Async Task to  Save review Details
     */
    class SaveReviewDetails extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditReviewActivity.this);
            pDialog.setMessage("Saving review ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Saving review
         */
        protected String doInBackground(String... args) {

            // getting updated data from EditTexts
            String property_id = txtProperty_id.getText().toString();
            String review_content = txtReviewContent.getText().toString();
            String rating = txtRating.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair(TAG_RID, rid));
            params.add(new BasicNameValuePair(TAG_REVIEW_CONTENT, review_content));
            params.add(new BasicNameValuePair(TAG_PROPERTY_ID, property_id));
            params.add(new BasicNameValuePair(TAG_RATING, rating));

            // sending modified data through http request
            // Notice that update product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_update_review,
                    "POST", params);

            // check json success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully updated
                    Intent i = getIntent();
                    // send result code 100 to notify about review update
                    setResult(100, i);
                    finish();
                } else {
                    // failed to update review
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once review updated
            pDialog.dismiss();
        }
    }

    /*****************************************************************
     * Background Async Task to Delete review
     * */
    class DeleteReview extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditReviewActivity.this);
            pDialog.setMessage("Deleting Review...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Deleting review
         */
        protected String doInBackground(String... args) {

            // Check for success tag
            int success;
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("rid", rid));

                // getting review details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(
                        url_delete_review, "POST", params);

                // check your log for json response
                Log.d("Delete Review", json.toString());

                // json success tag
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    // review successfully deleted
                    // notify previous activity by sending code 100
                    Intent i = getIntent();
                    // send result code 100 to notify about review deletion
                    setResult(100, i);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once review deleted
            pDialog.dismiss();

        }

    }
}