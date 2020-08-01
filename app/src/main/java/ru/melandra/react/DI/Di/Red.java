package ru.melandra.react.DI.Di;

import android.util.Log;

public class Red {
    public Red(Green green) {
        Log.d("[DI]", green.show() + ": " + green.toString());
    }
}
