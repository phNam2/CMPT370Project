package com.example.peter.myhome.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.peter.myhome.Current_User;
import com.example.peter.myhome.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Random;

import static android.os.Build.ID;


/**
 * Created by Nam on 2017-10-29.
 */

public class PaymentReceipt extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_receipt);


        int current = PaymentActivity.currentBalance - PaymentActivity.amount;
        int amount = PaymentActivity.amount;
        String method = PaymentActivity.method;
        String des = "Rent payment before deadline";

        new PaymentUpdate().execute(Integer.toString(current), Integer.toString(Current_User.getUserID()));
        new PaymentInsert().execute(Integer.toString(Current_User.getUserID()), des, Integer.toString(amount), method, String.valueOf(true));

        String r = getSaltString();
        java.util.Date today = new java.util.Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(today);

        TextView name = (TextView) findViewById(R.id.receipt_name);
        name.setText(Current_User.getFName() + " " + Current_User.getLName());
        TextView date = (TextView) findViewById(R.id.receipt_date);
        date.setText(s);
        TextView amount1 = (TextView) findViewById(R.id.receipt_amount);
        amount1.setText(amount + "");
        TextView bal = (TextView) findViewById(R.id.receipt_balance);
        bal.setText(current + "");
        TextView code = (TextView) findViewById(R.id.receipt_code);
        code.setText(r);

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

    //https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}