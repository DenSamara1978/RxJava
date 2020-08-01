package ru.melandra.react.DI.Dagger;

import android.util.Log;

import javax.inject.Inject;

public class White {

    @Inject
    Green green;

    public White() {
        DaggerApp.getAppComponent().inject(this);
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
