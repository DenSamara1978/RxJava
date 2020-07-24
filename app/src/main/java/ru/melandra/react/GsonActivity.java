package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonActivity extends AppCompatActivity {

    private String TAG = "[GSON]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        String json = "{\"time_of_year\": \"summer\", \"year\": 2019}";

        Gson gson = new GsonBuilder().create();
        Season season = gson.fromJson(json, Season.class);

        Log.d(TAG, "Season.timeOfYear is " + season.timeOfYear);
        Log.d(TAG, "Season.year is " + season.year);
    }
}