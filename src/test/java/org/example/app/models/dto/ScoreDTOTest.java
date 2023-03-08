package org.example.app.models.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDTOTest {

    @Test
    void set_getScore01() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore01(5d);
        assertEquals(5d,scoreDTO.getScore01());
    }

    @Test
    void set_getScore02() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore02(5d);
        assertEquals(5d,scoreDTO.getScore02());
    }

    @Test
    void set_getScore03() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore03(5d);
        assertEquals(5d,scoreDTO.getScore03());
    }

    @Test
    void set_getFresherId() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setFresherId("9999999999");
        assertEquals("9999999999",scoreDTO.getFresherId());
    }

    @Test
    void set_getSubjectId() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setSubjectId("J01");
        assertEquals("J01",scoreDTO.getSubjectId());
    }

    @Test
    void testScoreDTOConstructor() {
        ScoreDTO scoreDTO = new ScoreDTO(5d,6d,7d,"9999999999","C01");
        assertEquals(5d,scoreDTO.getScore01());
        assertEquals(6d,scoreDTO.getScore02());
        assertEquals(7d,scoreDTO.getScore03());
        assertEquals("9999999999",scoreDTO.getFresherId());
        assertEquals("C01",scoreDTO.getSubjectId());
    }
}