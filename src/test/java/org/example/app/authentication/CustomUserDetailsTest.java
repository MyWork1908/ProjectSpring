package org.example.app.authentication;

import org.example.app.models.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomUserDetailsTest {

    @Test
    void testCustomUserDetailsConstructor() {
        User user = new User(1L,"huy","123456");
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        assertEquals("huy",customUserDetails.getUsername());
        assertEquals("123456",customUserDetails.getPassword());
    }
}