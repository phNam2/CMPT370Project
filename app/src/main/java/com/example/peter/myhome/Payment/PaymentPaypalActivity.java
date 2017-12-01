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

public class PaymentPaypalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paying_paypal_page);
    }

    public void onButtonPayClick2(View v) {

        EditText email = (EditText) findViewById(R.id.email_text);
        EditText pass = (EditText) findViewById(R.id.password_text);

        if (email.getText().toString().equals(null) || email.getText().toString().equals("")
                || pass.getText().toString().equals(null) || pass.getText().toString().equals("")) {

            Toast.makeText(this, "Please enter to all the field", Toast.LENGTH_LONG).show();
        }
        else {

            Button pay = (Button) findViewById(R.id.login_button);
            pay.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(PaymentPaypalActivity.this, PaymentConfirm.class));
                }
            });
        }


    }
}
