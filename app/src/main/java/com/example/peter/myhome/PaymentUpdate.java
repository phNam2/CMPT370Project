package com.example.peter.myhome;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nam on 2017-11-30.
 */

public class PaymentUpdate extends AsyncTask<String, Void, Void> {

    private String errmsg="";
    @Override
    protected Void doInBackground(String... update) {


        Connection con = PaymentActivity.con;
        try{

            try{
                String sql;

                sql
                        = "Update Tenant_Landlord set Balance=? WHERE User_ID=?";
                PreparedStatement prest = con.prepareStatement(sql);

                prest.setInt(1, Integer.parseInt(update[0]));
                prest.setInt(2, Integer.parseInt(update[1]));
                prest.executeUpdate();

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
