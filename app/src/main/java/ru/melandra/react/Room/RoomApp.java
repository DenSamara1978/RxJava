package ru.melandra.react.Room;

import android.app.Application;

import androidx.room.Room;

public class RoomApp extends Application {
    private static final String DB_NAME = "USER_DB";
    public static RoomDB db;

    @Override
    public void onCreate() {
        super.onCreate();

        db = Room.databaseBuilder(getApplicationContext(), RoomDB.class, DB_NAME).build();
    }

    public static RoomDB getDB() {
        return db;
    }
}
