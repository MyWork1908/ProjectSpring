package org.example.app.models.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FresherDTOTest {

    @Test
    void getFresherId() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherId("2019606150");
        assertEquals("2019606150",fresherDTO.getFresherId());
    }

    @Test
    void getFresherName() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherName("Alice");
        assertEquals("Alice",fresherDTO.getFresherName());
    }

    @Test
    void set_getFresherAddress() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherAddress("America");
        assertEquals("America",fresherDTO.getFresherAddress());

    }

    @Test
    void set_getFresherPhone() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherPhone("0971561704");
        assertEquals("0971561704",fresherDTO.getFresherPhone());
    }

    @Test
    void set_getFresherEmail() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherEmail("chatgpt123@gmail.com");
        assertEquals("chatgpt123@gmail.com",fresherDTO.getFresherEmail());
    }

    @Test
    void testFresherDTOConstructor() {
        FresherDTO fresherDTO = new FresherDTO("2019606150","Alice","America",
                "0971561704","chatgpt123@gmail.com");
        assertEquals("2019606150",fresherDTO.getFresherId());
        assertEquals("Alice",fresherDTO.getFresherName());
        assertEquals("America",fresherDTO.getFresherAddress());
        assertEquals("0971561704",fresherDTO.getFresherPhone());
        assertEquals("chatgpt123@gmail.com",fresherDTO.getFresherEmail());
    }
}