package com.example.peter.myhome.Messaging;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.peter.myhome.R;


public class MessagingMailboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_mailbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagingMailboxActivity.this, MessagingNewMessageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void PopulateMessageList() {
        int MyUserId = 0;
        // TODO: get the current User Id.

        MessagingDatabaseConn DatabaseConn = new MessagingDatabaseConn();
        DatabaseConn.getMessageFromDatabase(MyUserId);
    }

    private void DeleteMessage() {

    }

    private void SelectMessage() {
        int MessageId;

    }

}
