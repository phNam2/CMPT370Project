package com.example.peter.myhome.Messaging;

import com.mysql.jdbc.Messages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagingDatabaseConn {

    public UserMessages getMessageFromDatabase(int UserId) {
        String sql = "SELECT From, Subject, Message FROM Messages" +
                " WHERE " + UserId + " = Messages.UserId;";

        Connection con = null;
        int count = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                PreparedStatement prest = con.prepareStatement(sql);
                ResultSet rs = prest.executeQuery();
                while (rs.next()){
                    rs.getString("From");
                    rs.getString("Subject");
                    rs.getString("Message");
                    count++;
                }
                System.out.println("Number of records: " + count);
                prest.close();
                con.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // TODO: Finish returning Messages.
        return null;
    }

    public void sendToDatabase(int SenderUserId, int RecipientUserId, String Subject, String Message) {
        String sql = "INSERT INTO Messages(SenderUserId, RecipientUserId, Subject, Message) VALUES (" + SenderUserId + ", " + RecipientUserId + ", " + Subject + ", " + Message + ");";

        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                PreparedStatement prest = con.prepareStatement(sql);
                prest.close();
                con.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteMessageFromDatabase(int UserId, int MessageId) {

    }
/*    public void sendMessage(int MyUserId, int UserId, String Subject, String Message) {
        sendToDatabase(MyUserId, UserId, Subject, Message);
    }
*/
}
