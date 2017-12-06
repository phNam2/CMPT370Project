package com.example.peter.myhome.Lease;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.example.peter.myhome.R;

/*
    Created by Lisa

 */
/*
    The Lease use case from the Landlord side.
    Incomplete since we did not create a view from the landlord side.
 */

public class LandlordLease extends AppCompatActivity {

    //Fields for tenant information
    //private EditText nameField;
    //private Button   submit;

    //Text fields for tenant renewal form
    //nameField = (EditText) findViewById(name);

    /*
    //create button object for xml submit button
    submit = (Button) findViewById(R.id.submit);
    */

    /*
    public void onButtonSubmit(View v) {
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LandlordLease.this, LandlordLease.class));
            }
        });
    }

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_lease);
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
    }

}
