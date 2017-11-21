package com.example.peter.myhome;

import android.content.Intent;
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

import static com.example.peter.myhome.R.id.address;
import static com.example.peter.myhome.R.id.name;
import static com.example.peter.myhome.R.id.propertyName;

public class TenantLease extends AppCompatActivity {

    private EditText nameField;
    private EditText addressField;
    private EditText propertyNameField;
    private Button submit;
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

        //Radio Buttons for lease renewal
        RadioButton yes = (RadioButton) findViewById(R.id.yes);
        RadioButton no = (RadioButton) findViewById(R.id.no);


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
                toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();

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

    }

//}
