package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;

public class SearchGuestActivity extends AppCompatActivity {

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
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });

        child.setMaxValue(10);
        child.setMinValue(0);
        child.setWrapSelectorWheel(true);
        child.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });
/*
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

 */
    }


    public void SaveGuests(View view) {

    }

    public void BackButton(View view) {
        Intent intent = new Intent(SearchGuestActivity.this, SearchActivity.class);
        startActivity(intent);
    }

}
