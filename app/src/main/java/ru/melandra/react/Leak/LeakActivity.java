package ru.melandra.react.Leak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import ru.melandra.react.R;

public class LeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        start();
    }

    private void start() {
        LeakDispatcher dispatcher = new LeakDispatcher(this);
        Observable<String> observable = dispatcher.getMessagePool ();
        observable.subscribe(string -> {
            Log.d("[LEAK]", Thread.currentThread().getName() + " received message");
        });
    }
}