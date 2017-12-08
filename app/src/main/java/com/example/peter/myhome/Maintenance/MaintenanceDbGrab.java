package com.example.peter.myhome.Maintenance;

import android.os.AsyncTask;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by Sherry on 2017-11-30.
 */

public class MaintenanceDbGrab extends AsyncTask<Void, Void, ResultSet> {
    private final String dbUser = "cmpt370_magic8b";
    private final String dbPassword = "p2z9ZhNfoKTOFsXpqAnP";
    private final String dbUrl = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
    private ResultSet rs = null;
    private TextView title, time, date, building, landlord, comment;
    private String userId;

    /**
     * Constructor: When calling this constructor you send it the current Userid and all the references
     * to the EditText objects in the profile so that it knows about them to set their values
     * @param userId
     */
    public MaintenanceDbGrab (int userId, TextView title, TextView time, TextView date, TextView building, TextView landlord, TextView comment){
        this.userId = Integer.toString(userId);
        this.title = title;
        this.time = time;
        this.date = date;
        this.building = building;
        this.landlord = landlord;
        this.comment = comment;
//        this.tenant = tenant;
    }

    /**
     * Connects to the database off of the UI thread. Then returns the ResultSet so that it can
     * be used in the onPostExecute method to populate the correct fields
     * @param voids
     * @return
     */
    @Override
    protected ResultSet doInBackground(Void... voids) {
        Connection con = openConnection();

        try {
            rs = con.createStatement().executeQuery("SELECT * FROM Maintenance WHERE idTenants=" + userId + " AND idMaintenance = 1"  );
            return rs;


        }catch(Exception e){
            e.printStackTrace();
            return null;
        }}

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

    /**
     * this is where the text fields are populated. After the background process of interacting
     * with the database occurs.
     * @param rs the ResultSet return from the background process
     */
    @Override
    protected void onPostExecute(ResultSet rs) {

        try {
            if(rs.next()) {

                title.setText(rs.getString("Title"));
                date.setText(rs.getString("Posting_date"));
                time.setText(rs.getString("Posting_time"));
                building.setText("Building: "+rs.getString("idProperty"));
                landlord.setText("Landlord: "+rs.getString("idLandlord"));
                comment.setText(rs.getString("Comment"));
//                tenant.setText(rs.getString("Occupant_ID"));
            }
        }catch(Exception e){e.printStackTrace();}
    }
}
