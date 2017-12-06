package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;

public class SearchGuestActivity extends AppCompatActivity {
    public static int[] textfile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_guest);
        NumberPicker adult = (NumberPicker) findViewById(R.id.adult_num);
        NumberPicker child = (NumberPicker) findViewById(R.id.child_num);

        adult.setMaxValue(10);
        adult.setMinValue(1);
        adult.setWrapSelectorWheel(true);
        adult.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldnum, int newnum) {
 //               textfile[0] = newnum;
            }
        });

        child.setMaxValue(10);
        child.setMinValue(0);
        child.setWrapSelectorWheel(true);
        child.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldnum, int newnum) {
//                textfile[1] = newnum;
            }
        });

    }


    public void SaveGuests(View view) {
        Intent search = new Intent(SearchGuestActivity.this, SearchResultActivity.class);
        search.putExtra(String.valueOf(textfile),textfile);
  //      startActivity(search);
    }

    public void BackButton(View view) {
        Intent intent = new Intent(SearchGuestActivity.this, SearchActivity.class);
        startActivity(intent);
    }

}
