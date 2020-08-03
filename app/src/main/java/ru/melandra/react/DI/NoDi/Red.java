package ru.melandra.react.DI.NoDi;

import android.util.Log;

public class Red {
    public Red() {
        Green green = Green.getInstance();
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
