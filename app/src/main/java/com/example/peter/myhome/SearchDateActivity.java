package com.example.peter.myhome;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toolbar;


public class SearchDateActivity extends AppCompatActivity {
    int day;
    int month;
    int year;
    public static int[] textfile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_date);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth() + 1;
        year = datePicker.getYear();

    }


//save the date in the datepicker and send the inform to the result page
    public void SaveDate(View view) {
        int[] Date = new int[3];
        Date[0] = day;
        Date[1] = month;
        Date[2] = year;
        Intent search = new Intent(SearchDateActivity.this, SearchResultActivity.class);
        search.putExtra(String.valueOf(textfile),Date);
  //      startActivity(search);

    }

    //conncet the back button to the function
    public void BackButton(View view) {
        Intent intent = new Intent(SearchDateActivity.this, SearchActivity.class);
        startActivity(intent);
    }

}
