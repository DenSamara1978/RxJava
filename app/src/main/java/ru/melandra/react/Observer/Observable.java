package ru.melandra.react.Observer;

public interface Observable {
    void subscribe (Observer subscriber);
    void unsubscribe (Observer subscriber);
    void sendMessage (String message);
}
