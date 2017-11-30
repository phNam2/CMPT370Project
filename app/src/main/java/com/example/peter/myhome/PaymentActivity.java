package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nam on 2017-10-28.
 */

public class PaymentActivity extends AppCompatActivity {

    public static int amount = 0;

    Button history, card, paypal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_first_page);
    }

    public void onButtonHistoryClick(View v) {

    }

    public void onButtonCardClick(View v) {
        EditText edit = (EditText) findViewById(R.id.amount_enter);
        if (edit.getText().toString().equals(null) || edit.getText().toString().equals("")) {

            Toast.makeText(this, "Please enter the amount to pay first", Toast.LENGTH_LONG).show();
        }
        else {
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
