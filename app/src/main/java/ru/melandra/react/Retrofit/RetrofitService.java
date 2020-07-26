package ru.melandra.react.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("/users/JakeWharton")
    Observable<User> getUser();
}
