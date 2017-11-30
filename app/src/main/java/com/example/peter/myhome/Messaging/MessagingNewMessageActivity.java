package com.example.peter.myhome.Messaging;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.peter.myhome.R;


public class MessagingNewMessageActivity extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_new_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
*/

    protected void sendMessage(int MyUserId) {
        int UserId = 0;
        String Subject = "TestSubject";
        String Message = "TestMessage";

        // TODO: Get info input by user.
        MessagingDatabaseConn SendMessage = new MessagingDatabaseConn();
        SendMessage.sendToDatabase(MyUserId, UserId, Subject, Message);
    }

}
