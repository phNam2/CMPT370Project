package com.example.peter.myhome;

/**
 * Created by Nam on 2017-11-26.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.widget.TextView;

public class A_jdbcActivity extends Activity implements Runnable{

    private int ID = 0;
    private String FN="";
    private String LN="";
    private String errmsg="";

    public void run() {

        Connection con = null;
        int count = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                String sql;
                //	  sql
                //	  = "SELECT title,year_made FROM movies WHERE year_made >= ? AND year_made <= ?";
                sql
                        = "SELECT Applicant_ID,FName,LName FROM Applicants";
                PreparedStatement prest = con.prepareStatement(sql);
                //prest.setInt(1,1980);
                //prest.setInt(2,2004);
                ResultSet rs = prest.executeQuery();
                while (rs.next()){

                    ID = rs.getInt("Applicant_ID");
                    FN = rs.getString("FName");
                    LN = rs.getString("LName");
                    count++;
                }
                System.out.println("Number of records: " + count);
                prest.close();
                con.close();
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

            TextView textView = (TextView) findViewById(R.id.textView0);
            textView.setText(" ID="+ID+ " First Name="+FN+" Last Name="+LN+" "+errmsg);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_jdbc);

        Thread thread = new Thread(this);
        thread.start();
    }


}