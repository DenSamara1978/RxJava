package ru.melandra.react.DI.NoDi;

import android.util.Log;

public class White {
    public White() {
        Green green = Green.getInstance();
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
