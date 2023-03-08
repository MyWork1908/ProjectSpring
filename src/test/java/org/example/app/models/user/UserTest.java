package org.example.app.models.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        User user = new User();
        user.setId(390000000000L);
        assertEquals(390000000000L,user.getId());
    }

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("huy");
        assertEquals("huy",user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("123456");
        assertEquals("123456",user.getPassword());
    }

    @Test
    void setId() {
        User user = new User();
        user.setId(390000000000L);
        assertEquals(390000000000L,user.getId());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("huy");
        assertEquals("huy",user.getUsername());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("123456");
        assertEquals("123456",user.getPassword());
    }
    @Test
    void testUserConstructor(){
        User user = new User(12345L,"huy","123456");
        assertEquals(12345L,user.getId());
        assertEquals("huy",user.getUsername());
        assertEquals("123456",user.getPassword());
    }
}