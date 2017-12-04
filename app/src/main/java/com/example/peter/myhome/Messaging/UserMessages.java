package com.example.peter.myhome.Messaging;


/**
 * This class holds a message and it's details.
 */
public class UserMessages {
    private int SenderUserId; // Stores the Sender's User Id.
    private int RecipientUserId; // Stores the Recipient's User Id.
    private String Subject; // Stores the Subject of the message.
    private String Message; // Stores the Message.

    /**
     * The Constructor of User Messages.
     * @param senderUID An int containing the Sender's User Id.
     * @param recipientUserId An Int containing the Recipient's User Id.
     * @param subject An String containing the Subject of the message.
     * @param message An String containing the Message.
     */
    protected UserMessages(int senderUID, int recipientUserId, String subject, String message) {
        SenderUserId = senderUID;
        RecipientUserId = recipientUserId;
        Subject = subject;
        Message = message;
    }

    /**
     * The Getter for Sender's User id.
     * @return An Int containing the Sender's User id.
     */
    public int getSenderUserId() {
        return SenderUserId;
    }

    /**
     * The Getter for Recipient's User id.
     * @return An int containing the Recipient's User id.
     */
    public int getRecipientUserId() {
        return RecipientUserId;
    }

    /**
     * The Getter for the Subject of the Message.
     * @return An String containing the Messages subject.
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * The Getter for the Message.
     * @return An String containing the Message.
     */
    public String getMessage() {
        return Message;
    }

}
