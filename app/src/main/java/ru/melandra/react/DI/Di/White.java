package ru.melandra.react.DI.Di;

import android.util.Log;

public class White {
    public White(Green green) {
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
