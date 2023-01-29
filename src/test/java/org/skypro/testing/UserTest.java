package org.skypro.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skypro.exception.NotCorrectEmailException;
import org.skypro.exception.UserParametersIsEqualException;


class UserTest {
    @Test
    @DisplayName("When User is created with login and email then these parameters are installed correct")
    void createUser() {
        String login = "login";
        String email = "mail@mail.ru";
        User user = new User(login, email);
        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(email, user.getEmail());
    }

    @Test
    @DisplayName("When Users Constructor is empty, then login and email are null")
    void createEmptyUser() {
        User user = new User();
        Assertions.assertNull(user.getEmail());
        Assertions.assertNull(user.getLogin());
    }

    @Test
    @DisplayName("When email has @ and '.' NOT at the end, then email is correct")
    void correctMail() {
        String login = "login";
        String email = "mail@mail.ru";
        Assertions.assertDoesNotThrow(() -> new User(login, email));
    }

    @Test
    @DisplayName("When email has @ and '.' at the end, then email is NOT correct")
    void notCorrectMail() {
        String login = "login";
        String email = "mail@.";
        Assertions.assertThrows(NotCorrectEmailException.class, () -> new User(login, email),
                "Check setMail method");
    }

    @Test
    @DisplayName("When login is not equals email, then parameters are correct")
    void equalsLoginAndMail() {
        String login = "@d.ru";
        String email = "@d.ru";
        Assertions.assertThrows(UserParametersIsEqualException.class, () -> new User(login, email),
                "It must throw exception!");
    }

}
