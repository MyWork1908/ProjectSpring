package org.example.app.models.dto.mapper;

import org.example.app.models.dto.ScoreDTO;
import org.example.app.models.entity.Score;

public class ScoreMapper {
    public Score toScore(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setScore01(scoreDTO.getScore01());
        score.setScore02(scoreDTO.getScore02());
        score.setScore03(scoreDTO.getScore03());
        return score;
    }

}
