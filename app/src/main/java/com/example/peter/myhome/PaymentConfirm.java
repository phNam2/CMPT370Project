package com.example.peter.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nam on 2017-10-29.
 */

public class PaymentConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_confirm);

        TextView textView = (TextView) findViewById(R.id.amount_view);
        //EditText amount = (EditText) findViewById(R.id.amount_enter);

        //int number = Integer.parseInt(amount.getText().toString());
        textView.setText(50 + "");
    }

    public void onToReceipt(View v) {
        Button testing = (Button) findViewById(R.id.confirm_button);
        testing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PaymentConfirm.this, PaymentReceipt.class));
            }
        });
    }

}
