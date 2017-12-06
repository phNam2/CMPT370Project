package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    Button editProfile;
    TextView name;
    TextView phone;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editProfile = (Button) findViewById(R.id.profileButton);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserProfileActivity.this, UserProfileEditActivity.class);
                finish();
                startActivity(intent);
            }
        });

        name = (TextView) findViewById(R.id.nameView);
        email = (TextView) findViewById(R.id.emailView);
        phone = (TextView) findViewById(R.id.phoneView);
        populateFields();


    }


    private void populateFields(){
        ProfileViewPopulateFields m = new ProfileViewPopulateFields(Integer.toString(Current_User.UserID), name, email, phone);
        m.execute();
        //TODO need to create a static userId variable. Could also use email
        //m.doInBackground(), );
    }
}
