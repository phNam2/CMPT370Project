package com.example.peter.myhome.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.peter.myhome.Current_User;
import com.example.peter.myhome.R;


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