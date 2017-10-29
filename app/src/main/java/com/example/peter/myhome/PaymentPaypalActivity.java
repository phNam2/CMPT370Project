package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nam on 2017-10-28.
 */

public class PaymentPaypalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paying_paypal_page);
    }

    public void onButtonPayClick2(View v) {
        Button pay = (Button) findViewById(R.id.login_button);
        pay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentPaypalActivity.this, PaymentConfirm.class));
            }
        });
    }
}
