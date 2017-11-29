package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by Nam on 2017-10-29.
 */

public class PaymentReceipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_receipt);
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