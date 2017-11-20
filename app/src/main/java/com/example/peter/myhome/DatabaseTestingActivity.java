package com.example.peter.myhome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
/**
 * Created by Nam on 2017-11-13.
 */

public class DatabaseTestingActivity extends AppCompatActivity {

    EditText FirstName, LastName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_testing);

        FirstName = (EditText)findViewById(R.id.FirstN);
        LastName = (EditText)findViewById(R.id.LastN);
    }

    public void OnLogin(View view) {
        String first = FirstName.getText().toString();
        String last = LastName.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, first, last);
    }
}
