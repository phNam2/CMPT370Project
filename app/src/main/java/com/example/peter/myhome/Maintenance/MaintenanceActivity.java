package com.example.peter.myhome.Maintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.peter.myhome.R;

public class MaintenanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        defineButtons();
    }

    // The buttons
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
