package ru.melandra.react.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users_tbl")
    Single<List<User>> getAllUsers();

    @Query("SELECT * FROM users_tbl WHERE id = :id")
    Single<List<User>> getUserById(int id);

    @Insert
    Single<Long> insert(User user);

    @Insert
    Single<List<Long>> insert(List<User> userList);

    @Delete
    Single<Integer> delete(User user);

    @Update
    Single<Integer> update(User user);
}
