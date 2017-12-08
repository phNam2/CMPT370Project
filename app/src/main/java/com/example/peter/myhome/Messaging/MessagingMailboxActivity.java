package com.example.peter.myhome.Messaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.peter.myhome.R;


public class MessagingMailboxActivity extends AppCompatActivity {

    /**
     * This is the floating message button for createing a new Message.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_mailbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onNewMessageClick(View v) {

        // This opens the create a new message screen.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagingMailboxActivity.this, MessagingNewMessageActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This populates the Users messages list.
     */
    private void PopulateMessageList() {
        int MyUserId = 0;
        // TODO: get the current User Id.
        // TODO: Populate Message List.
        MessagingDatabaseConn DatabaseConn = new MessagingDatabaseConn();
        DatabaseConn.getMessageFromDatabase(MyUserId);
    }

    /**
     * This deletes a specified message.
     */
    private void DeleteMessage() {
        // TODO: Connect DeleteMessage to Message.
    }

    /**
     * This opens a specified message to view.
     */
    private void SelectMessage() {
        int MessageId;
        // TODO: Connect Select Message to Open Message.
    }

}
