package com.moon.fc.project.core;

import com.moon.fc.project.core.domain.entity.User;
import com.moon.fc.project.core.util.Encryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {

    private final Encryptor alwaysMatchEncryptor = new Encryptor() {
        @Override
        public String encrypt(String origin) {
            return origin;
        }

        @Override
        public boolean isMatch(String origin, String hashed) {
            return true;
        }
    };

    @Test
    void isMatchTest() {
        final User me = new User("meme", "email", "pw", LocalDate.now());
        Assertions.assertEquals(true, me.isMatch(alwaysMatchEncryptor, "aaaa"));
    }
}
