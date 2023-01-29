package org.skypro.testing;

import org.skypro.exception.NotCorrectEmailException;
import org.skypro.exception.UserParametersIsEqualException;

public class User {

    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if (loginAndMailIsNotEqual(login, email)) {
            this.login = login;
            setEmail(email);
        } else {
            throw new UserParametersIsEqualException();
        }
    }

    private void setEmail(String email) {
        if (email.contains("@") && email.contains(".") && !(email.endsWith("@") || email.endsWith("."))) {
            this.email = email;
            return;
        }
        throw new NotCorrectEmailException();
    }

    private boolean loginAndMailIsNotEqual(String login, String email) {
        return !login.equals(email);
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
