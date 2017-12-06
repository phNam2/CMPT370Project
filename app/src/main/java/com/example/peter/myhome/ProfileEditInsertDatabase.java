package com.example.peter.myhome;

import android.content.Intent;
import android.os.AsyncTask;

import java.sql.*;

/**
 * Created by Graeme on 2017-11-29.
 */

public class ProfileEditInsertDatabase extends AsyncTask<String, Void,Void> {
    private final String dbUser = "cmpt370_magic8b";
    private final String dbPassword = "p2z9ZhNfoKTOFsXpqAnP";
    private final String dbUrl = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
    private PreparedStatement ps = null;
    @Override
    protected Void doInBackground(String... insertStrings) {
        Connection con = openConnection();
        //The person's name comes as one string. Have to split it to put it into the first and last
        //name columns of the database
        String nameSplitter[] = insertStrings[0].split(" ");
        String firstName = nameSplitter[0];
        String lastName = nameSplitter[1];

        String sql = "update Applicants set FName = ?, LName = ?, Phone_number = ?, Email = ? where Applicant_ID=?";

        try{
        ps = con.prepareStatement(sql);

        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, insertStrings[1]);
        ps.setString(4, insertStrings[2]);
        ps.setString(5, Integer.toString(Current_User.getUserID()));

        ps.executeUpdate();

        con.close();


        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }


    /**
     * Opens the connection to the database
     * @return
     */
    private Connection openConnection(){
        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return con;
        }catch(Exception e){e.printStackTrace();}

        return null;
    }


}

