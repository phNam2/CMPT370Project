package com.example.peter.myhome.Maintenance;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peter.myhome.R;
import com.example.peter.myhome.Current_User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewMaintenanceActivity extends AppCompatActivity {

    // Required fields
    private EditText titleText;
    private TextView timeText, dateText, buildingText, landlordText;
    private EditText commentText;
    private Current_User user;
    int buildingInt, landlordInt;
    private String title, time, date, comment, building, landlord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_maintenance);
        setupPage();
        defineButtons();
    }

    // Set up the page with time, date, landlord and building auto-filled
    @TargetApi(25)
    public void setupPage() {
        Calendar c = Calendar.getInstance();

        titleText = (EditText) findViewById(R.id.title_text);
        commentText = (EditText) findViewById(R.id.comment_text);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formatTime = timeFormat.format(c.getTime());
        timeText = (TextView) findViewById(R.id.time_text);
        timeText.setText("Time: " + formatTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = dateFormat.format(c.getTime());
        dateText = (TextView) findViewById(R.id.date_text);
        dateText.setText("Date: " + formatDate);

        buildingText = (TextView) findViewById(R.id.building_text);
        landlordText = (TextView) findViewById(R.id.landlord_text);

        new MaintenanceDbGrabRequestInfo(user.getUserID(), buildingText, landlordText).execute();
    }

    // Grab and assign values to respective variables to send to database
    public void assignValues(){
        title = titleText.getText().toString();
        time = timeText.getText().toString();
        date = dateText.getText().toString();
        comment = commentText.getText().toString();

        building = buildingText.getText().toString();
        String s3[] = building.split(":");
        String s4[] = s3[1].split(" ");
        building = s4[1];
        buildingInt = Integer.parseInt(building);

        landlord = landlordText.getText().toString();
        String s5[] = landlord.split(":");
        String s6[] = s5[1].split(" ");
        landlord = s6[1];
        landlordInt = Integer.parseInt(landlord);
    }

    // Insert new maintenance request into database
    public void transferToDB(){
        MaintenanceDBInsert mdi = new MaintenanceDBInsert(user.getUserID(), title, time, date, buildingInt, landlordInt, comment);
        mdi.execute();
    }

    // Defines the button
    public void defineButtons() {
        findViewById(R.id.submit_btn).setOnClickListener(buttonClickListener);
    }

    // Actions for clicking button
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.submit_btn:

                    assignValues();
                    transferToDB();

                    Toast toast = new Toast(getApplicationContext());
                    Toast.makeText(getApplicationContext(), "Request Submitted!", Toast.LENGTH_SHORT).show();

                    finish();
                    break;
            }
        }
    };

}
