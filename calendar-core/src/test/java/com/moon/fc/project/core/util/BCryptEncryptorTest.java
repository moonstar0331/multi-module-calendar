package com.moon.fc.project.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BCryptEncryptorTest {

    @Test
    void test() {
        final String origin = "password";
        final Encryptor encryptor = new BCryptEncryptor();
        final String hash = encryptor.encrypt(origin);

        Assertions.assertTrue(encryptor.isMatch(origin, hash));

        final String origin2 = "passwordd";
        Assertions.assertFalse(encryptor.isMatch(origin2, hash));
    }
}
