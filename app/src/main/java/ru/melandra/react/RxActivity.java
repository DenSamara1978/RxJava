package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {

    private Dispatcher dispatcher;
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        dispatcher = new Dispatcher();
        observable = dispatcher.getMessagePool();

        makeButtons ();
    }

    private void makeButtons () {
        findViewById(R.id.rxSubscribeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        RxActivity.this.disposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("[RX]", Thread.currentThread().getName() + " received: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                Log.d ("[RX]", "Subscribing have executed");
            }
        });

        findViewById(R.id.rxUnsubsribeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disposable.dispose();
            }
        });
    }
}