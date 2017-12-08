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

import static com.example.peter.myhome.SearchResultActivity.pDialog;

//import android.support.v7.widget.SearchView;

/**
 * Created by Administrator on 2017/11/18.
 */

//main activity for the searching

public class SearchActivity extends AppCompatActivity {


    private String[] mStrs = {"Vancouver", "Toronto", "ottawa", "Montreal","Calgary","Saskatoon"};
    public SearchView mSearchView;
    private ListView mListView;
//    private ListView listView;
    private List<SearchResultActivity> resultList = new ArrayList<SearchResultActivity>();

    private SearchHelper db_helper;
    public static String textfile = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//conncet everything to the xml file

        setContentView(R.layout.activity_search);
        mSearchView = (SearchView) findViewById(R.id.searchbar);
        mListView = (ListView) findViewById(R.id.ResultView);
        final CharSequence locain = mSearchView.getQuery();
        textfile = locain.toString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mStrs);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mListView.setTextFilterEnabled(true);
        mSearchView.setSubmitButtonEnabled(true);

        //give the searchview the functions which can give search suggestions and search
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()){
                   // return  false;
                }
                else{

                    if (pDialog != null && pDialog.isShowing()){
                        pDialog.dismiss();
                    }
                    Intent search = new Intent(getApplicationContext(), SearchResultActivity.class);
//                    Intent search = new Intent();
//                    search.setClassName("SearchActivity","SearchResultActivity");
//                    search.putExtra(textfile,query);
                    startActivity(search);
                    //return true;
                }
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

//connect to the function with two buttons
    public void InputGuest(View view) {
        Intent intent = new Intent(SearchActivity.this, SearchGuestActivity.class);
        startActivity(intent);
    }

    public void InputDate(View view) {
        Intent intent = new Intent(SearchActivity.this, SearchDateActivity.class);
        startActivity(intent);
    }

/*
    public void SearchResult(View view) {
        Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
        startActivity(intent);
    }

*/
}
