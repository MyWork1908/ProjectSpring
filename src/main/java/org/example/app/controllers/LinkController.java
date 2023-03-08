package org.example.app.controllers;

import org.example.app.models.dto.ScoreDTO;
import org.example.app.models.dto.mapper.ScoreMapper;
import org.example.app.models.entity.Score;
import org.example.app.models.response.ResponseObject;
import org.example.app.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    LinkService linkService;
    @PostMapping("/score")
    public @ResponseBody ResponseEntity<ResponseObject> addScore(@RequestBody ScoreDTO scoreDTO) {
        ScoreMapper scoreMapper = new ScoreMapper();
        Score score = scoreMapper.toScore(scoreDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add score successfully",
                        linkService.addScore(score, scoreDTO.getFresherId(), scoreDTO.getSubjectId()))
        );
    }

    @PostMapping("/fc/{centerCode}")
    public @ResponseBody ResponseEntity<ResponseObject> adFresherToCenter(@RequestParam String fresherId,
                                                                          @PathVariable String centerCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add fresher to center successfully",
                        linkService.addFresherToCenter(fresherId,centerCode))
        );
    }
}
