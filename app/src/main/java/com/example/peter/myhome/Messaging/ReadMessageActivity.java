package com.example.peter.myhome.Messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.peter.myhome.R;

public class ReadMessageActivity extends AppCompatActivity {

    // Gets the TextViews that will be populated with the messages.
    TextView FromTextView = (TextView)findViewById(R.id.FromDataLb);
    TextView SubjectTextView = (TextView)findViewById(R.id.SubjectDataLb);
    TextView MessageTextView = (TextView)findViewById(R.id.messageDataLb);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        UserMessages TheMessage = new UserMessages(1, 2, "TestSubject", "Test Message"); // Temp for testing and showing no error here.
        // TODO: Connect Message being passed in to this Activity somehow?
        OpenMessage(TheMessage);
    }

    /**
     * Takes in the Message being opened and populates the Text Labels in the activity.
     * @param TheMessage A UserMessages containing the message being opened.
     */
     private void OpenMessage(UserMessages TheMessage) {
         // Below sets the text in the TextViews.
         FromTextView.setText(TheMessage.getSenderUserId());
         SubjectTextView.setText(TheMessage.getSubject());
         MessageTextView.setText(TheMessage.getMessage());
    }
}
