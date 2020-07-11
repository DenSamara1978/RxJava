package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {

    private Dispatcher dispatcher;
    private Observable<String> observable;
    private Disposable disposable;

    @BindView(R.id.rxSubscribeButton)
    protected Button subscribeButton;

    @BindView(R.id.rxUnsubscribeButton)
    protected Button unsubscribeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        ButterKnife.bind(this);

        dispatcher = new Dispatcher();
        observable = dispatcher.getMessagePool();
    }

    @OnClick(R.id.rxSubscribeButton)
    protected void subscribe (View view) {
        disposable = observable.subscribe(string -> {
            Log.d("[RX]", Thread.currentThread().getName() + " received: " + string);
        }, throwable -> {
            Log.d("[RX]", Thread.currentThread().getName() + " generates error: " + throwable.getMessage());
        }, ()-> {
            Log.d("[RX]", Thread.currentThread().getName() + " completed.");
        });
    }

    @OnClick(R.id.rxUnsubscribeButton)
    protected void unsubscribe (View view) {
        disposable.dispose();
    }
}