package ru.melandra.react.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_tbl")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String surname;

    public int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
