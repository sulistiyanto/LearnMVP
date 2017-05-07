package id.learnmvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.learnmvp.R;
import id.learnmvp.presenter.LoginPresenter;
import id.learnmvp.presenter.LoginPresenterImp;
import id.learnmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter mLoginPresenter;
    private EditText etUsername;
    private EditText etPass;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi view standar
        etUsername = (EditText) findViewById(R.id.et_username);
        etPass = (EditText) findViewById(R.id.et_pass);
        btLogin = (Button) findViewById(R.id.bt_login);

        mLoginPresenter = new LoginPresenterImp(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login(etUsername.getText().toString(), etPass.getText().toString());
            }
        });
    }

    // fungsi yang dipanggil saat validasi error
    @Override
    public void showValidationError() {
        Toast.makeText(this, "Please enter valid username and password!", Toast.LENGTH_SHORT).show();
    }

    // fungsi yang dipanggil saat login sukses
    @Override
    public void loginSuccess() {
        Toast.makeText(this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();
    }

    // fungsi yang dipanggil saat login error
    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
    }
}
