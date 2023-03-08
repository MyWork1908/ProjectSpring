package org.example.app.models.dto.mapper;

import org.example.app.models.dto.CenterDTO;
import org.example.app.models.dto.ScoreDTO;
import org.example.app.models.entity.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreMapperTest {

    @Test
    void toScore() {
        ScoreDTO scoreDTO = new ScoreDTO(5d,6d,7d,"","");
        ScoreMapper scoreMapper = new ScoreMapper();
        Score score = scoreMapper.toScore(scoreDTO);
        assertEquals(5d,score.getScore01());
        assertEquals(6d,score.getScore02());
        assertEquals(7d,score.getScore03());
    }
}