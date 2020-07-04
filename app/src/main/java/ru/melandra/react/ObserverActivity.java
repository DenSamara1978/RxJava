package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ru.melandra.react.Observer.Receiver;
import ru.melandra.react.Observer.Sender;

public class ObserverActivity extends AppCompatActivity {

    private Receiver receiver;
    private Sender sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        makeObjects ();
        makeButtons ();
    }

    private void makeObjects () {
        sender = new Sender ();
        receiver = new Receiver();
    }

    private void makeButtons () {
        findViewById(R.id.subscribeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sender.subscribe(receiver);
            }
        });

        findViewById(R.id.unsubscribeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sender.unsubscribe(receiver);
            }
        });

        findViewById(R.id.spamButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sender.sendMessage("New message");
            }
        });
    }
}