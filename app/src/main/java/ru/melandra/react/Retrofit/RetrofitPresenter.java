package ru.melandra.react.Retrofit;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RetrofitPresenter {

    public void getAvatarUrl(RetrofitActivity activity) {
        RetrofitModel model = RetrofitModel.getInstance();
        Observable<User> single = model.getUser();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            activity.takeAvatarUrl(user.avatarUrl);
        }, throwable -> {
            Log.e("[Retrofit-GSON]", "onError " + throwable );
        });
    }
}
