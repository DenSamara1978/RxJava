package ru.melandra.react.Observer;

import android.util.Log;

public class Receiver implements Observer {
    @Override
    public void receiveMessage(String message) {
        Log.d("[OBSERVER]", "New message: " + message);
    }
}
