package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nam on 2017-10-28.
 */

public class PaymentActivity extends AppCompatActivity {

    Button history, card, paypal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_first_page);
    }

    public void onButtonHistoryClick(View v) {

    }

    public void onButtonCardClick(View v) {
        card = (Button) findViewById(R.id.card_button);
        card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentActivity.this, PaymentCardActivity.class));
            }
        });
    }

    public void onButtonPaypalClick(View v) {
        paypal = (Button) findViewById(R.id.paypal);
        paypal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentActivity.this, PaymentPaypalActivity.class));
            }
        });
    }
}
