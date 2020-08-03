package ru.melandra.react.DI.Dagger;

import android.util.Log;

import javax.inject.Inject;

public class Red {

    @Inject
    Green green;

    public Red() {
        DaggerApp.getAppComponent().inject(this);
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
