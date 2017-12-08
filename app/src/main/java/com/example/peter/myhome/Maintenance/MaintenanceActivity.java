package com.example.peter.myhome.Maintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.peter.myhome.Current_User;
import com.example.peter.myhome.R;

public class MaintenanceActivity extends AppCompatActivity {

    private TextView title, time, date, building, landlord, comment;
    private Current_User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        defineButtons();
        defineText();
        MaintenanceDbGrab mdg = new MaintenanceDbGrab(user.getUserID(), title, time, date, building, landlord, comment);
        mdg.execute();
    }

    // Defines the text on the screen
    public void defineText() {
        title = (TextView) findViewById(R.id.title_text);
        time = (TextView) findViewById(R.id.time_text);
        date = (TextView) findViewById(R.id.date_text);
        building = (TextView) findViewById(R.id.building_text);
        landlord = (TextView) findViewById(R.id.landlord_text);
        comment = (TextView) findViewById(R.id.comment_text);
    }


    // Define the buttons
    public void defineButtons() {
        findViewById(R.id.new_maintenance_btn).setOnClickListener(buttonClickListener);
        findViewById(R.id.history_btn).setOnClickListener(buttonClickListener);
    }

    // Actions for clicking buttons
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                // Open up NewMaintenanceActivity when clicked
                case R.id.new_maintenance_btn:
                    startActivity(new Intent(MaintenanceActivity.this, NewMaintenanceActivity.class));
                    break;
                // Open up MaintenanceHistoryActivity when clicked
                case R.id.history_btn:
                    startActivity(new Intent(MaintenanceActivity.this, MaintenanceHistoryActivity.class));
                    break;
            }
        }
    };



}
