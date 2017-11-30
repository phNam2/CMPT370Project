package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Nam on 2017-10-29.
 */

public class PaymentReceipt extends AppCompatActivity implements Runnable{

    private String errmsg="";

    public void run() {

        Connection con = PaymentActivity.con;
        try{

            try{
                String sql;

                sql
                        = "Update Tenant_Landlord set Balance=? WHERE User_ID=?";
                PreparedStatement prest = con.prepareStatement(sql);

                int current = PaymentActivity.currentBalance - PaymentActivity.amount;
                prest.setInt(1, current);
                prest.setInt(2, Current_User.getUserID());

                //String sql2;

                //sql2
                //        = "Insert into Payment (Tenant_ID, Description, Amount, Method, Payment_date, Pay_verification) value(?, ?, ?, ?, ?, ?)";
                //prest = con.prepareStatement(sql2);

                //DateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
                //Date today = new Date();
                //Date todayWithZeroTime = formatter.parse(formatter.format(today));

                //prest.setInt(1, Current_User.getUserID());
                //prest.setString(2, "Rent payment before deadline");
                //prest.setInt(3, PaymentActivity.amount);
                //prest.setString(4, PaymentActivity.method);
                //prest.setDate(5, (java.sql.Date) todayWithZeroTime);
                //prest.setBoolean(6, true);

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

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_receipt);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void onGoBack(View v) {

        Button testing = (Button) findViewById(R.id.backID);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentReceipt.this, PaymentActivity.class));
            }
        });

    }

}