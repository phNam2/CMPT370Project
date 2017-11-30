package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UserProfileEditActivity extends AppCompatActivity {

    Button saveButton;
    EditText name;
    EditText phone;
    EditText email;
    public static boolean updateFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_edit);
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

        name = (EditText) findViewById(R.id.nameText);
        phone = (EditText) findViewById(R.id.phoneText);
        email = (EditText) findViewById(R.id.emailText);
        populateFields();




        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                create new ProfileEditInsertDatabase class, call the execute method and pass the text from all the fields
                as String classes to the background process. To save whatever is in the fields into the database
                */
                updateFinished = false;
                new ProfileEditInsertDatabase().execute(name.getText().toString(),phone.getText().toString(),  email.getText().toString());

                    //start up UserProfileActivity
                    Intent intent = new Intent(UserProfileEditActivity.this, UserProfileActivity.class);
                    finish();
                    startActivity(intent);

                }
        });

    }

    private void populateFields(){
        ProfileViewPopulateFields m = new ProfileViewPopulateFields(Integer.toString(LoginActivity.currentUser), name, email, phone);
        m.execute();


    }
}
