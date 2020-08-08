package ru.melandra.react.Leak;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class LeakDispatcher {

    LeakActivity activity;

    public LeakDispatcher(LeakActivity activity) {
        this.activity = activity;
    }

    public Observable<String> getMessagePool () {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 30; ++i) {
                    TimeUnit.SECONDS.sleep(3);
                    String message = "Message " + i;
                    Log.d("[LEAK]", Thread.currentThread().getName() + " generates message: " + activity);
                    emitter.onNext(message);
                }
                emitter.onComplete();
            } catch (Exception e){
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }
}
