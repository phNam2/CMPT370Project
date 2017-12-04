package com.example.peter.myhome.Messaging;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.peter.myhome.R;


public class MessagingNewMessageActivity extends AppCompatActivity {

    EditText RecipientInputBox = (EditText)findViewById(R.id.RecipientTB);
    EditText SubjectInputBox = (EditText)findViewById(R.id.SubjectTB);
    EditText MessageMessageBox = (EditText)findViewById(R.id.MessageTB);

    /**
     * Gets the details input by the user and sends a message when the Send button is pressed.
     */
    protected void sendMessage() {
        int MySenderUserId = 1;
        int RecipientUserId = 2; // TODO: get recipient UserId from Input.
        String Subject = SubjectInputBox.getText().toString();
        String Message = MessageMessageBox.getText().toString();
        UserMessages NewMessage = new UserMessages(MySenderUserId, RecipientUserId, Subject, Message);

        // TODO: Connect to send Button on click.

        MessagingDatabaseConn SendMessage = new MessagingDatabaseConn();
        SendMessage.sendUserMessage(NewMessage);
    }
}
