package ru.melandra.react;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class Dispatcher {

    public Observable<String> getMessagePool () {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 5; ++i) {
                        TimeUnit.SECONDS.sleep(1);
                        String message = "Message " + i;
                        Log.d("[RX]", Thread.currentThread().getName() + " generates: " + message);
                        emitter.onNext(message);
                    }
                } catch (Exception e){

                }
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }
}
