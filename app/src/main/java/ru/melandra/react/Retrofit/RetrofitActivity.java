package ru.melandra.react.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ru.melandra.react.R;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RetrofitPresenter presenter = new RetrofitPresenter();
        presenter.getAvatarUrl(this);
    }

    public void takeAvatarUrl(String url) {
        Log.d("[Retrofit-GSON]", url);
        Glide.with(this)
             .load("https://avatars0.githubusercontent.com/u/66577?v=4")
             .into((ImageView)findViewById(R.id.imageView));
    }
}