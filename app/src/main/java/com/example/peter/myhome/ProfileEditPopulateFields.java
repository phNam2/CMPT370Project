package com.example.peter.myhome;

import android.os.AsyncTask;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by Graeme on 2017-11-29.
 */

public class ProfileEditPopulateFields extends AsyncTask<Void, Void, ResultSet> {

    private final String dbUser = "cmpt370_magic8b";
    private final String dbPassword = "p2z9ZhNfoKTOFsXpqAnP";
    private final String dbUrl = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
    private ResultSet rs = null;
    private EditText name;
    private EditText phone;
    private EditText email;
    private String userId;


    /**
     * Constructor: When calling this constructor you send it the current Userid and all the references
     * to the EditText objects in the profile so that it knows about them to set their values
     * @param userId
     * @param name
     * @param phone
     * @param email
     */
    public ProfileEditPopulateFields(String userId, EditText name, EditText phone, EditText email){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }

    /**
     * Connects to the database off of the UI thread. Then returns the ResultSet so that it can
     * be used in the onPostExecute method to populate the fields in the profile
     * @param voids
     * @return
     */
    @Override
    protected ResultSet doInBackground(Void... voids) {
        Connection con = openConnection();

        try {
            rs = con.createStatement().executeQuery("SELECT * FROM Tenant_Landlord WHERE User_ID=" + userId);
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
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");

                email.setText(rs.getString("Email"));
                phone.setText(rs.getString("Phone_number"));
                name.setText(firstName + " " + lastName);
            }
        }catch(Exception e){e.printStackTrace();}

    }
}
