package org.example.app.models.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void getUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("huy");
        assertEquals("huy",loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123456");
        assertEquals("123456",loginRequest.getPassword());
    }

    @Test
    void setUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("huy");
        assertEquals("huy",loginRequest.getUsername());
    }

    @Test
    void setPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123456");
        assertEquals("123456",loginRequest.getPassword());
    }
    @Test
    void testLoginRequestConstructor() {
        LoginRequest loginRequest = new LoginRequest("huy","123456");
        assertEquals("huy",loginRequest.getUsername());
        assertEquals("123456",loginRequest.getPassword());
    }
}