package com.example.peter.myhome.Maintenance;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.example.peter.myhome.R;
import com.example.peter.myhome.Current_User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewMaintenanceActivity extends AppCompatActivity {

    private EditText titleText;
    private TextView timeText, dateText, buildingText, tenantText, landlordText;
    private MultiAutoCompleteTextView commentText;
    private Current_User user;
    private int tenant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_maintenance);

        setupPage();
    }

    // To get text entered in text box
    public String grabText(EditText textbox) {
        String content = textbox.getText().toString();
        return content;
    }

    // Set up the page with auto-filled sections
    @TargetApi(25)
    public void setupPage() {
        Calendar c = Calendar.getInstance();

//        titleText = (EditText) findViewById(R.id.title_text);
//        titleText.setText("Request Title");

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formatTime = timeFormat.format(c.getTime());
        timeText = (TextView) findViewById(R.id.time_text);
        timeText.setText("Time: " + formatTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = dateFormat.format(c.getTime());
        dateText = (TextView) findViewById(R.id.date_text);
        dateText.setText("Date: " + formatDate);

        // Grab building from db
        buildingText = (TextView) findViewById(R.id.building_text);
        buildingText.setText("Building: ");

        // Grab tenant from db
        tenantText = (TextView) findViewById(R.id.tenant_text);
        tenant = user.getUserID();
        tenantText.setText("Tenant: ");

        // Grab landlord from db
        landlordText = (TextView) findViewById(R.id.landlord_text);
        landlordText.setText("Landlord: ");

//        commentText = (MultiAutoCompleteTextView) findViewById(R.id.comment_text);
//        commentText.setText("Insert comments...");
    }

    // The buttons
    public void defineButtons() {
        findViewById(R.id.save_btn).setOnClickListener(buttonClickListener);
        findViewById(R.id.submit_btn).setOnClickListener(buttonClickListener);
    }

    // Actions for clicking buttons
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.save_btn:
                    break;
                case R.id.submit_btn:
                    break;
            }
        }
    };


}
