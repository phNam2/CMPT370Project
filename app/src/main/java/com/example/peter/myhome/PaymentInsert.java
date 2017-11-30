package com.example.peter.myhome;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Nam on 2017-11-30.
 */

public class PaymentInsert extends AsyncTask<String, Void, Void> {

    private String errmsg="";
    @Override
    protected Void doInBackground(String... update) {


        Connection con = PaymentActivity.con;
        try{

            try{

                String sql2;

                sql2
                        = "Insert into Payment (Tenant_ID, Description, Amount, Method, Payment_date, Pay_verification) value(?, ?, ?, ?, ?, ?)";
                PreparedStatement prest = con.prepareStatement(sql2);

                prest.setInt(1, Integer.parseInt(update[0]));
                prest.setString(2, update[1]);
                prest.setInt(3, Integer.parseInt(update[2]));
                prest.setString(4, update[3]);
                prest.setDate(5, (java.sql.Date) new SimpleDateFormat("yyyy/mm/dd").parse(update[4]));
                prest.setBoolean(6, Boolean.valueOf(update[5]));

                prest.executeUpdate();
                prest.close();

            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                errmsg=errmsg+s.getMessage();
                s.printStackTrace();

            }
        }
        catch (Exception e){
            e.printStackTrace();
            errmsg=errmsg+e.getMessage();
        }



        return null;
    }
}
