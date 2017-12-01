package com.example.peter.myhome.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.peter.myhome.R;

/**
 * Created by Nam on 2017-11-30.
 */

public class PaymentFail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_fail);
    }

    public void failReturnClick(View v) {
        Button testing = (Button) findViewById(R.id.fail_return);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentFail.this, PaymentActivity.class));
            }
        });
    }
}
