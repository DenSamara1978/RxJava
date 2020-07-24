package ru.melandra.react.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModel {
    private static RetrofitModel self = null;

    public static RetrofitModel getInstance() {
        if (RetrofitModel.self == null)
            RetrofitModel.self = new RetrofitModel();
        return RetrofitModel.self;
    }

    private RetrofitModel() {
    }

    public Observable<User> getUser() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        GsonConverterFactory converterFactory = GsonConverterFactory.create(gson);

        RetrofitService service = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(converterFactory)
                .build()
                .create(RetrofitService.class);

        return service.getUser().subscribeOn(Schedulers.io());
    }
}
