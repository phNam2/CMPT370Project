package com.example.peter.myhome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewMainActivity extends Activity {


    Button btnViewReviews;
    Button btnNewReview;
    Button btnDBtesting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_review_main);

        // Buttons
        btnViewReviews = (Button) findViewById(R.id.btnViewReviews);
        btnNewReview = (Button) findViewById(R.id.btnCreateReview);
        btnDBtesting = (Button) findViewById(R.id.btnDBtesting);

        // view products click event
        btnViewReviews.setOnClickListener(new View.OnClickListener() {

        @Override
                public void onClick(View view) {
                // Launching All products Activity
                Intent i = new Intent(getApplicationContext(), AllReviewsActivity.class);
                startActivity(i);

        }
        });
        // view reviews click event
        btnNewReview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), NewReviewActivity.class);
            startActivity(i);

            }
        });

        btnDBtesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DatabaseTestingActivity.class);
                startActivity(i);

            }
        });
    }

}
