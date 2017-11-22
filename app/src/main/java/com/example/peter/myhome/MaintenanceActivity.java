package com.example.peter.myhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MaintenanceActivity extends AppCompatActivity {

    private Spinner maintenanceSpinner;
    private Button newMaintenanceBtn, maintenanceHistoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        addItemsOnCurrentMaintenanceSpinner();
        addListenerOnNewMaintenanceBtn();
        addListenerOnMaintenanceHistoryBtn();
        addListenerOnSpinnerItemSelection();
    }

    // To populate the spinner, interaction with db
    public void  addItemsOnCurrentMaintenanceSpinner() {
        maintenanceSpinner = (Spinner) findViewById(R.id.maintenance_spinner);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
    }

    // Open up NewMaintenanceActivity when clicked
    public void addListenerOnNewMaintenanceBtn() {

        ImageButton newMaintenanceBtn = (ImageButton) findViewById(R.id.new_maintenance_btn);
        newMaintenanceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MaintenanceActivity.this, NewMaintenanceActivity.class));
            }
        });
    }

    // Open up MaintenanceHistoryActivity when clicked
    public void addListenerOnMaintenanceHistoryBtn() {

        Button maintenanceHistoryBtn = (Button) findViewById(R.id.history_btn);
        maintenanceHistoryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MaintenanceActivity.this, MaintenanceHistoryActivity.class));
            }
        });
    }

    // To set an action upon spinner selection
    public void addListenerOnSpinnerItemSelection() {
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // Upon selecting an item on spinner change title text
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
//        // On selecting a spinner item
//
//        SpinnerFAQ = parent.getItemAtPosition(position).toString();
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "You selected: " + SpinnerFAQ,
//                Toast.LENGTH_LONG).show();
//
//        TextView tv = (TextView) findViewById(R.id.faq_answer);
//        ExerciseData question = new ExerciseData(this);
//        question.open();
//        String answer = question.getFaqAnswer();
//        question.close();
//        tv.setText(answer);

    }

    // Store the text from spinner
    public void getFaqAnswer(){
//    public String getFaqAnswer() {
//        // TODO Auto-generated method stub
//        String[] columns = new String[] { FAQ_ROWID, FAQ_QUESTION, FAQ_ANSWER};
//        Cursor c = ourDatabase.query(DATABASE_TABLE2, columns, null, null, null, null, null);
//        String result = "";
//
//        int iRow = c.getColumnIndex(FAQ_ROWID);
//        int iQuestion = c.getColumnIndex(FAQ_QUESTION);
//        int iAnswer = c.getColumnIndex(FAQ_ANSWER);
//
//        //c.getString(iRow) + " " +
//
//        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
//        {
//            if(FAQ.SpinnerFAQ == c.getString(iQuestion))
//            {
//                result = result + c.getString(iAnswer) + "\n";
//                break;
//            }
//        }
//
//        return result;
    }


    // Autopopulate scroll view with db information
    // Autoresize text for titles
    // Insert a visual timeline possibly
    // Change colours
}
