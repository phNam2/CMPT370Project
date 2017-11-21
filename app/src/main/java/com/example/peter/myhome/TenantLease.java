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
import android.widget.RadioButton;
import android.widget.Toast;

public class TenantLease extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_lease);
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


        //Text fields for tenant renewal form
        EditText name = (EditText) findViewById(R.id.name);
        EditText address = (EditText) findViewById(R.id.address);
        EditText propertyName = (EditText) findViewById(R.id.propertyName);

        //Radio Buttons for lease renewal
        RadioButton yes = (RadioButton) findViewById(R.id.yes);
        RadioButton no = (RadioButton) findViewById(R.id.no);

        //create button object for xml submit button
        Button submit = (Button) findViewById(R.id.submit);
        //set button to be unclickable after it's created. Will change after fields are filled out
        submit.setClickable(false);
        //when clicked the button sends a toast
        
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();

            }
        });

    }




 /*   public void onButtonSubmit(View v) {
            Button submit = (Button) findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(TenantLease.this, TenantLeaseConfirm.class));
                }
            });
*/
        //still need method for sending submission to database once
        //database connection is working

        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.yes:
                    if (checked)
                        // send info to database
                        break;
                case R.id.no:
                    if (checked)
                        // send info to database
                        break;
            }
        }



    }

//}
