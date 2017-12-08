package com.example.peter.myhome.Maintenance;

import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sherry on 2017-12-05.
 */

public class MaintenanceDBInsert extends AsyncTask<String, String, String> {

    // Fields for connection to database
    private static final String DB_URL = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
    private static final String USER = "cmpt370_magic8b";
    private static final String PASSWORD = "p2z9ZhNfoKTOFsXpqAnP";

    // Other required fields
    private String titleText, timeText, dateText, commentText;
    private int userId, building, landlord;

    //String for database connection message
    String msg = "";

    // Constructor for MaintenanceDBInsert
    public MaintenanceDBInsert(int userId, String title, String time, String date, int building, int landlord, String comment){
        this.userId = userId;
        titleText = title;
        timeText = time;
        dateText = date;
        this.building = building;
        this.landlord = landlord;
        commentText = comment;
    }

    // Does the actual work of sending request to database
    protected String doInBackground (String... strings){

        String s[] = timeText.split(":");
        timeText = s[1]+":"+s[2]+":"+s[3];

        String s2[] = dateText.split(":");
        dateText = s2[1];

        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            if (conn == null){
                msg = "Something is wrong";
            }
            else{
                String query = "INSERT INTO Maintenance (idProperty, idLandlord, idTenants, Title, Status, Comment, Posting_date, Posting_time)" +
                        "VALUES ('"+building+"', '"+landlord+"', '"+userId+"', '"+titleText+"', 'In Progress', '"+commentText+"', '"+dateText+"', '"+timeText+"');";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                msg = "Inserting...";
            }
            conn.close();
        }catch(SQLException e){
            msg = "Something is REALLY wrong";
            e.printStackTrace();
        }
        return msg;
    }
}
