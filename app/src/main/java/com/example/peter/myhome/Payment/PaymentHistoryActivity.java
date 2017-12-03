package com.example.peter.myhome.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.peter.myhome.Current_User;
import com.example.peter.myhome.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Nam on 2017-12-01.
 */

public class PaymentHistoryActivity extends AppCompatActivity implements Runnable{

    private String errmsg="";
    private LinkedList<Integer> amount = null;
    private LinkedList<String> met = null;
    private LinkedList<Timestamp> date = null;
    public String sql = "";

    public void run() {

        amount = new LinkedList<Integer>();
        met = new LinkedList<String>();
        date = new LinkedList<Timestamp>();
        try{

            Connection con = PaymentActivity.con;
            try{

                PreparedStatement prest = con.prepareStatement(sql);

                prest.setInt(1, Current_User.getUserID());

                ResultSet rs = prest.executeQuery();
                while (rs.next()){

                    amount.add(rs.getInt("Amount"));
                    met.add(rs.getString( "Method"));
                    date.add(rs.getTimestamp("Payment_date"));
                }

                prest.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                errmsg=errmsg+s.getMessage();

            }
        }
        catch (Exception e){
            e.printStackTrace();
            errmsg=errmsg+e.getMessage();
        }

        handler.sendEmptyMessage(0);

    }
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            String s1 = "";
            String s2 = "";
            String s3 = "";
            Iterator Iterator1 = amount.iterator();
            Iterator Iterator2 = met.iterator();
            Iterator Iterator3 = date.iterator();

            //while (Iterator1.hasNext() && Iterator2.hasNext()) {

            //    s = s + Iterator1.next() + "\t\t" + Iterator2.next() + "\t\t" +"\n";
            //}
            while (Iterator1.hasNext() && Iterator2.hasNext() && Iterator3.hasNext()) {

                s1 = s1 + Iterator1.next() + "\n";
                s2 = s2 + Iterator2.next() + "\n";
                s3 = s3 + Iterator3.next() + "\n";

            }

            TextView textView1 = (TextView) findViewById(R.id.amount_view);
            textView1.setText(s1);
            TextView textView2 = (TextView) findViewById(R.id.method_view);
            textView2.setText(s2);
            TextView textView3 = (TextView) findViewById(R.id.date_view);
            textView3.setText(s3);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_history);

        sql = "SELECT Amount, Method, Payment_date FROM Payment WHERE Tenant_ID=?";
        callThead();
    }

    public void onButtonHistoryAmount(View v) {

        sql = "SELECT Amount, Method, Payment_date FROM Payment WHERE Tenant_ID=? ORDER BY Amount";
        Button history = (Button) findViewById(R.id.history_amount);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callThead();
            }
        });
    }

    public void onButtonHistoryMethod(View v) {

        sql = "SELECT Amount, Method, Payment_date FROM Payment WHERE Tenant_ID=? ORDER BY Method";
        Button history = (Button) findViewById(R.id.history_method);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callThead();
            }
        });
    }

    public void onButtonHistoryDate(View v) {

        sql = "SELECT Amount, Method, Payment_date FROM Payment WHERE Tenant_ID=? ORDER BY Payment_date";
        Button history = (Button) findViewById(R.id.history_date);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callThead();
            }
        });
    }

    public void callThead() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
