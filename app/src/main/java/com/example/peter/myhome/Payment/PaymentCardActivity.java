package com.example.peter.myhome.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peter.myhome.R;

/**
 * Created by Nam on 2017-10-28.
 */

public class PaymentCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paying_card_page);
    }

    public void onButtonPayClick1(View v) {

        EditText name = (EditText) findViewById(R.id.user_name);
        EditText number = (EditText) findViewById(R.id.card_number);
        EditText date = (EditText) findViewById(R.id.card_date);

        if (name.getText().toString().equals(null) || name.getText().toString().equals("")
                || number.getText().toString().equals(null) || number.getText().toString().equals("")
                || date.getText().toString().equals(null) || date.getText().toString().equals("")) {

            Toast.makeText(this, "Please enter to all the field", Toast.LENGTH_LONG).show();
        }
        else {

            Button pay = (Button) findViewById(R.id.pay_button);
            pay.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(PaymentCardActivity.this, PaymentConfirm.class));
                }
            });
        }

    }
}
