package com.example.peter.myhome;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;


public class NewMaintenanceActivity extends AppCompatActivity {

    private Button saveBtn, submitBtn;
    private EditText titleText, timeText, dateText, buildingText, tenantText, landlordText;
    private MultiAutoCompleteTextView commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_maintenance);

        addListenerOnSaveBtn();
        addListenerOnSubmitBtn();
    }

    // Set up the page with auto-filled sections
    @TargetApi(25)
    public void setupPage() {
        Calendar c = Calendar.getInstance();

        // Grab title from db if exists
        titleText.setText("Request Title");

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formatTime = timeFormat.format(c.getTime());
        timeText.setText(formatTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = dateFormat.format(c.getTime());
        dateText.setText(formatDate);

        // Grab building from db
        buildingText.setText("Building Name");
        // Grab tenant from db
        tenantText.setText("Tenant Name");
        // Grab landlord from db
        landlordText.setText("Landlord Name");

        // Grab comment details from db if exists
        commentText.setText("Comments...");
    }

    // To get the text in the textbox
    public String grabText(EditText textbox) {
        String content = textbox.getText().toString();
        return content;
    }

    // To save a draft of request into db
    public void addListenerOnSaveBtn() {

        Button saveBtn = (Button) findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //save onto db
                // grab title
                // grab comment
            }
        });
    }

    // To submit the request into db
    public void addListenerOnSubmitBtn() {

        Button submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //save onto db and submit
            }
        });
    }
}
