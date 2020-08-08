package ru.melandra.react.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.melandra.react.R;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.labelTextView)
    protected TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.actionButton)
    protected void action() {
        label.setText("Sample text");
    }
}