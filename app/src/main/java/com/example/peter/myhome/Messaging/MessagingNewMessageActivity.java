package com.example.peter.myhome.Messaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.peter.myhome.R;


public class MessagingNewMessageActivity extends AppCompatActivity {

    EditText RecipientInputBox = null;
    EditText SubjectInputBox = null;
    EditText MessageMessageBox = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_new_message);

        RecipientInputBox = (EditText)findViewById(R.id.RecipientTB);
        SubjectInputBox = (EditText)findViewById(R.id.SubjectTB);
        MessageMessageBox = (EditText)findViewById(R.id.MessageTB);
    }

    /**
     * Gets the details input by the user and sends a message when the Send button is pressed.
     */
    public void sendMessage(View V) {

        int MySenderUserId = 1;
        String RUIDTemp = RecipientInputBox.getText().toString();
        int RecipientUserId = Integer.valueOf(RUIDTemp);
        String Subject = SubjectInputBox.getText().toString();
        String Message = MessageMessageBox.getText().toString();
        UserMessages NewMessage = new UserMessages(MySenderUserId, RecipientUserId, Subject, Message);

        // TODO: Connect to send Button on click.

        MessagingDatabaseConn SendMessage = new MessagingDatabaseConn();
        SendMessage.sendUserMessage(NewMessage);
    }

}
