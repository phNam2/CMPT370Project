package com.example.peter.myhome;

/**
 * Created by Nam on 2017-11-10.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseConnector {

    public void getInformation () throws Exception{

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = null;
        ResultSet result = null;
        try {

            String url = "jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b";
            String user = "cmpt370_magic8b";
            String password = "p2z9ZhNfoKTOFsXpqAnP";

            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            System.out.println(e);
        }

        
    }
}
