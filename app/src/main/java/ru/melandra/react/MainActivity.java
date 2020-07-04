package ru.melandra.react;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private LocalAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeButton();
    }

    private void makeButton () {
        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new LocalAsyncTask();
                task.execute ();
                Log.d("[ASYNC]", Thread.currentThread().getName() + ": async execution completed");
            }
        });
    }

    private static class LocalAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 5; ++i) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d("[ASYNC]", Thread.currentThread().getName() + ": notification");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}