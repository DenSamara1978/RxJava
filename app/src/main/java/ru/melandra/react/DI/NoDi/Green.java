package ru.melandra.react.DI.NoDi;

public class Green {
    private static Green instance = null;

    private Green() {
    }

    public static Green getInstance() {
        if (instance == null)
            instance = new Green();
        return instance;
    }

    public String show() {
        return "green";
    }
}
