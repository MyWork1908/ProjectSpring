package org.example.app.models.dto.mapper;

import org.example.app.models.dto.FresherDTO;
import org.example.app.models.entity.Fresher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FresherMapperTest {

    @Test
    void toFresher() {
        FresherDTO fresherDTO = new FresherDTO("2019606150","Alice","America",
                "0971561704","chatgpt123@gmail.com");
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        assertEquals("2019606150",fresher.getFresherId());
        assertEquals("Alice",fresher.getFresherName());
        assertEquals("America",fresher.getFresherAddress());
        assertEquals("0971561704",fresher.getFresherPhone());
        assertEquals("chatgpt123@gmail.com",fresher.getFresherEmail());
    }
}