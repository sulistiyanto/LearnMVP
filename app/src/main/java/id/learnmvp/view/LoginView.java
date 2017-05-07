package id.learnmvp.view;

/**
 * Created by TOSHIBA on 19/04/2017.
 */

public interface LoginView {

    /**
     * Menampilkan toast validation error.
     */
    void showValidationError();
    /**
     * Login success.
     */
    void loginSuccess();
    /**
     * Menampilkan toast login error.
     */
    void loginError();

}
