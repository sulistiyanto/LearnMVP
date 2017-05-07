package id.learnmvp.presenter;

import android.text.TextUtils;

import id.learnmvp.view.LoginView;

/**
 * Created by TOSHIBA on 19/04/2017.
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenterImp(LoginView loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mLoginView.showValidationError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }
        }
    }
}
