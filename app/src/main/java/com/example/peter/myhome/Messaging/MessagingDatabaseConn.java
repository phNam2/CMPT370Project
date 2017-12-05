package com.example.peter.myhome.Messaging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MessagingDatabaseConn {

    // TODO: Fix Database Connection Error When Run. WHY CAN'T IT FIND THE JDBC DRIVER!!!!!

    /**
     * This gets the messages from the database for the specified User.
     * @param UserId A int containing the User Id.
     * @return An array of Messages that are for the specified user.
     */
    public UserMessages[] getMessageFromDatabase(int UserId) {
        // The SQL statement for getting the message.
        String sql = "SELECT From, Subject, Message FROM Messages" +
                " WHERE " + UserId + " = Messages.UserId AND" +
                " Deleted = FALSE;";

        UserMessages [] TheMessages = null; // This will store the messages in an array of UserMessages.

        // Below is the details to connect and perform the SQL statement on the database.
        Connection con = null;
        int count = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                PreparedStatement prest = con.prepareStatement(sql);
                ResultSet rs = prest.executeQuery();
                while (rs.next()){ // Gets the Messsages and puts them into an array of User Messages.
                    int SenderId = rs.getInt("SenderUserId");
                    int RecipientId = rs.getInt("RecipientUserId");
                    String Subject = rs.getString("Subject");
                    String Message = rs.getString("Message");
                    TheMessages[count] = new UserMessages(SenderId, RecipientId, Subject, Message);
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
        return TheMessages;
    }

      /**
     * This is a helper function to insert a message into the database to "send" a message to another user.
     * @param SenderUserId A int containing the Sender's User Id to know where the message is from.
     * @param RecipientUserId A int containing the Recipient's User Id to know where the message is going.
     * @param Subject A String containing the Subject of the message.
     * @param Message A String containing the body of the Message.
     */
    public void sendToDatabase(int SenderUserId, int RecipientUserId, String Subject, String Message) {
        String sql = "INSERT INTO Messages(SenderUserId, RecipientUserId, Subject, Message, Deleted) " +
                "VALUES (" + SenderUserId + ", " + RecipientUserId + ", '" + Subject + "', '" + Message + "', FALSE);";

        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db.cs.usask.ca:3306/cmpt370_magic8b","cmpt370_magic8b","p2z9ZhNfoKTOFsXpqAnP");
            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);

                con.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception thrown.");
        }
        System.out.println("Finished Send To DB");
    }

    /**
     * This changes a messages deleted parameter to TRUE marking a message as deleted.
     * @param UserId A int containing the User Id.
     * @param MessageId A int containing the Message Id.
     */
    public void deleteMessageFromDatabase(int UserId, int MessageId) {
        // TODO: Finish Delete.
    }

    /**
     * Takes in a UserMessages and breaks it down for the sendToDatabase helper Function.
     * @param TheMessage A UserMessages Containing the Message for sending.
     */
    public void sendUserMessage(UserMessages TheMessage) {
        sendToDatabase(TheMessage.getSenderUserId(), TheMessage.getRecipientUserId(), TheMessage.getSubject(), TheMessage.getMessage());
    }

    /**
     * Testing Functions above.
     */
    public static void main(String args[]) {
        System.out.println("Started Testing");
        MessagingDatabaseConn Test = new MessagingDatabaseConn();
        Test.sendToDatabase(1, 2, "Test Subject", "Test Message");
        System.out.println("Finished Testing");

    }
}
