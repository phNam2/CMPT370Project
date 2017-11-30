package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nam on 2017-10-28.
 */

public class PaymentActivity extends AppCompatActivity implements Runnable {

    public static String method = "";
    public static int currentBalance = 0;
    public static int amount = 0;
    private String errmsg="";
    public static Connection con = null;

    Button history, card, paypal;


    public void run() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                String sql;
                //	  sql
                //	  = "SELECT title,year_made FROM movies WHERE year_made >= ? AND year_made <= ?";
                sql
                        = "SELECT Balance FROM Tenant_Landlord WHERE User_ID=?";
                PreparedStatement prest = con.prepareStatement(sql);

                prest.setInt(1, Current_User.getUserID());

                ResultSet rs = prest.executeQuery();
                while (rs.next()){

                    currentBalance = rs.getInt("Balance");
                }

                prest.close();
                con.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                errmsg=errmsg+s.getMessage();

            }
        }
        catch (Exception e){
            e.printStackTrace();
            errmsg=errmsg+e.getMessage();
        }

        handler.sendEmptyMessage(0);

    }
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            TextView textView = (TextView) findViewById(R.id.balance_view);
            textView.setText(currentBalance + "");
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_first_page);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void onButtonHistoryClick(View v) {

    }

    public void onButtonCardClick(View v) {
        EditText edit = (EditText) findViewById(R.id.amount_enter);
        if (edit.getText().toString().equals(null) || edit.getText().toString().equals("")) {

            Toast.makeText(this, "Please enter the amount to pay first", Toast.LENGTH_LONG).show();
        }
        else {
            method = "Credit_Debit Card";
            amount = Integer.parseInt(edit.getText().toString());

            card = (Button) findViewById(R.id.card_button);
            card.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(PaymentActivity.this, PaymentCardActivity.class));
                }
            });
        }

    }

    public void onButtonPaypalClick(View v) {
        EditText edit = (EditText) findViewById(R.id.amount_enter);
        if (edit.getText().toString().equals(null) || edit.getText().toString().equals("")) {

            Toast.makeText(this, "Please enter the amount to pay first", Toast.LENGTH_LONG).show();
        }
        else {
            method = "Paypal";
            amount = Integer.parseInt(edit.getText().toString());

            paypal = (Button) findViewById(R.id.paypal);
            paypal.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(PaymentActivity.this, PaymentPaypalActivity.class));
                }
            });
        }

    }

    public void homepageClick(View v) {
        Button testing = (Button) findViewById(R.id.testingID);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentActivity.this, HomeActivity.class));
            }
        });
    }

    public void onTestClick(View v) {
        Button testing = (Button) findViewById(R.id.testingID);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentActivity.this, DatabaseTestingActivity.class));
            }
        });
    }

    public void onTestClick2(View v) {
        Button testing = (Button) findViewById(R.id.testingID);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentActivity.this, A_jdbcActivity.class));
            }
        });
    }
}
