package ru.melandra.react.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract UserDao userDao();
}
