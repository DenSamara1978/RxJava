package ru.melandra.react.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.melandra.react.R;

public class RoomActivity extends AppCompatActivity {

    private RoomPresenter presenter;

    @BindView(R.id.idField)
    protected EditText idField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        ButterKnife.bind(this);
        presenter = new RoomPresenter();
    }

    @OnClick(R.id.putUserButton)
    protected void putUser(View view) {
        presenter.putUser();
    }

    @OnClick(R.id.putUsersButton)
    protected void putUsers(View view) {
        presenter.putUsers();
    }

    @OnClick(R.id.getUserButton)
    protected void getUser(View view) {
        presenter.getUser(getId());
    }

    @OnClick(R.id.getUsersButton)
    protected void getUsers(View view) {
        presenter.getUsers();
    }

    @OnClick(R.id.updateUserButton)
    protected void updateUser(View view) {
        presenter.updateUser(getId());
    }

    @OnClick(R.id.deleteUserButton)
    protected void deleteUser(View view) {
        presenter.deleteUser(getId());
    }

    private int getId() {
        return Integer.parseInt(String.valueOf(idField.getText()));
    }

}