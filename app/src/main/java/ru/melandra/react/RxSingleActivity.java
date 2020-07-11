package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class RxSingleActivity extends AppCompatActivity {

    private Dispatcher dispatcher;
    private Single<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_single);

        ButterKnife.bind(this);

        dispatcher = new Dispatcher();
        observable = dispatcher.getSingleMessagePool ();

    }

    @OnClick (R.id.singleMessageButton)
    protected void getMessage (View view) {
        disposable = observable.subscribe(string -> {
            Log.d("[RX]", Thread.currentThread().getName() + " received: " + string);
        });
    }
}