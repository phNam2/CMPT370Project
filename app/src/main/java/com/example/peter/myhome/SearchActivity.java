package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

//import android.support.v7.widget.SearchView;

/**
 * Created by Administrator on 2017/11/18.
 */

public class SearchActivity extends AppCompatActivity {


    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    public SearchView mSearchView;
    private ListView mListView;
    private ListView listView;
    private List<SearchResult> resultList = new ArrayList<SearchResult>();

    private SearchHelper db_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mSearchView = (SearchView) findViewById(R.id.searchbar);
        mListView = (ListView) findViewById(R.id.ResultView);
 //       listView = (ListView)findViewById(R.id.ResultView);




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mStrs);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mListView.setTextFilterEnabled(true);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    mListView.setFilterText(newText);
                } else {
                    mListView.clearTextFilter();
                }
                return false;
            }
        });


    }


    public void InputGuest(View view) {
        Intent intent = new Intent(SearchActivity.this, SearchGuestActivity.class);
        startActivity(intent);
    }

    public void InputDate(View view) {
        Intent intent = new Intent(SearchActivity.this, SearchDateActivity.class);
        startActivity(intent);
    }



}
