package com.example.peter.myhome.Lease;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.peter.myhome.R;

import static com.example.peter.myhome.R.id.address;
import static com.example.peter.myhome.R.id.name;
import static com.example.peter.myhome.R.id.propertyName;

import java.sql.*;

public class TenantLease extends AppCompatActivity {

    //Fields for tenant information
    private EditText nameField;
    private EditText addressField;
    private EditText propertyNameField;
    private EditText responseField;
    private Button   submit;



    //Fields for connection to database
    private static final String DB_URL = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
    private static final String USER = "cmpt370_magic8b";
    private static final String PASSWORD = "p2z9ZhNfoKTOFsXpqAnP";



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
        nameField = (EditText) findViewById(name);
        addressField = (EditText) findViewById(R.id.address);
        propertyNameField = (EditText) findViewById(R.id.propertyName);
        responseField = (EditText) findViewById(R.id.response);





        //create button object for xml submit button
        submit = (Button) findViewById(R.id.submit);
        //set button to be unclickable after it's created. Will change after fields are filled out
        submit.setClickable(false);
        //when clicked the button sends a toast

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = new Toast(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();

            }
        });

        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setButtonToClickable();
            }

            @Override
            public void afterTextChanged(Editable s) {
                setButtonToClickable();
            }
        });

        addressField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setButtonToClickable();
            }

            @Override
            public void afterTextChanged(Editable s) {
                setButtonToClickable();
            }
        });

        propertyNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setButtonToClickable();
            }

            @Override
            public void afterTextChanged(Editable s) {
                setButtonToClickable();
            }
        });


    }




/*
    public void onButtonSubmit(View v) {
            Button submit = (Button) findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(TenantLease.this, TenantLeaseConfirm.class));
                }
            })
*/




    /**
     * Checks all editText fields and if they are not empty it will set button to be clickable
     *
     */
    private void setButtonToClickable(){
            if(makeSureAllEditTextFieldsHaveValuesEntered(new EditText[]{nameField, addressField, propertyNameField})){
                submit.setClickable(true);
            }
        }

    /**
     * checks if all editTexts are empty
     * @param fields
     * @return
     * True if all fields are non-empty
     */
    private boolean makeSureAllEditTextFieldsHaveValuesEntered(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length() <= 0){
                return false;
            }
        }
        return true;
    }

    public void buttonSubmit (View view){

        Send objSend = new Send ();
        objSend.execute("");
    }


    private class Send extends AsyncTask<String, String, String>{

        //String for database connection message
        String msg = "";

        String nameText = nameField.getText().toString();
        String addressText = addressField.getText().toString();
        String propertyNameText = propertyNameField.getText().toString();
        String responseText = responseField.getText().toString();

        protected String doInBackground (String... strings){

            try{

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                if (conn == null){

                    msg = "Something is wrong";
                }
                else{

                    String query = "INSERT INTO Lease (name, address, propertyName, response)" +
                            "VALUES ('"+nameText+"', '"+addressText+"', '"+propertyNameText+"', '"+responseText+"');";

                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "Inserting...";

                }
                conn.close();

            }catch(SQLException e){

                msg = "Something is REALLY wrong";
                e.printStackTrace();
            }
            return msg;

        }



    }

}

//}
