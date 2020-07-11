package ru.melandra.react;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Dispatcher {

    public Observable<String> getMessagePool () {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 5; ++i) {
                    TimeUnit.SECONDS.sleep(1);
                    String message = "Message " + i;
                    Log.d("[RX]", Thread.currentThread().getName() + " generates: " + message);
                    emitter.onNext(message);
                }
                emitter.onComplete();
            } catch (Exception e){
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }

    public Single<String> getSingleMessagePool () {
        Single<String> observable = Single.create((SingleOnSubscribe<String>) emitter -> {
            Log.d("[RX]", Thread.currentThread().getName() + " generates message.");
            emitter.onSuccess("message");
        }).subscribeOn(Schedulers.io());
        return observable;
    }
}
