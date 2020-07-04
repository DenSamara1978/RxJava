package ru.melandra.react.Observer;

import java.util.ArrayList;
import java.util.List;

public class Sender implements Observable {
    List<Observer> subscribers = new ArrayList<Observer>();

    @Override
    public void subscribe(Observer subscriber) {
        if (!subscribers.contains(subscriber))
            subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Observer subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void sendMessage(String message) {
        for ( Observer subscriber: subscribers ) {
            subscriber.receiveMessage(message);
        }
    }
}
