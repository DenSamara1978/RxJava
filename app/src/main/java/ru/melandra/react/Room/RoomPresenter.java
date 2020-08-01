package ru.melandra.react.Room;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomPresenter {
    private static final String TAG = "[Room]";

    private UserDao dao;

    public RoomPresenter() {
        dao = RoomApp.getDB().userDao();
    }


    public void putUser() {
        User user = new User();
        user.name = "John";
        user.surname = "Doe";
        user.age = 43;

        Disposable disposable = dao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putUser: " + id + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "putUser: " + throwable);
                });
    }


    public void putUsers() {
        User user = new User();
        user.name = "John";
        user.surname = "Doe";
        user.age = 43;

        List<User> users = new ArrayList();
        users.add(user);
        users.add(user);
        users.add(user);

        Disposable disposable = dao.insert(users).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putUser: " + id + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "putUser: " + throwable);
                });
    }

    public void updateUser(int id) {
        User user = new User();
        user.id = id;
        user.name = "Ivan";
        user.surname = "ivanov";
        user.age = 18;

        Disposable disposable = dao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(_id -> {
                    Log.d(TAG, "updateUser: " + _id + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "updateUser: " + throwable);
                });
    }
    public void getUser(int id) {
        Disposable disposable = dao.getUserById(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.d(TAG, "getUser: " + user + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getUser: " + throwable);
                });
    }

    public void getUsers() {
        Disposable disposable = dao.getAllUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "getUsers: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getUsers: " + throwable);
                });
    }

    public void deleteUser(int id) {
        User user = new User();
        user.id = id;
        Disposable disposable = dao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(_id -> {
                    Log.d(TAG, "deleteUser: " + _id + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "deleteUser: " + throwable);
                });
    }
}
