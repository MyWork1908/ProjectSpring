package org.example.app.service.implement;

import org.example.app.exception.NotFoundException;
import org.example.app.models.entity.*;
import org.example.app.models.response.ErrorMessages;
import org.example.app.models.response.Transcript;
import org.example.app.repositories.*;
import org.example.app.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    FresherRepository fresherRepository;
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    FresherCenterRepository fresherCenterRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public FresherCenter addFresherToCenter(String fresherId, String centerCode) {
        Optional<Fresher> fresher = fresherRepository.findById(fresherId);
        Optional<Center> center = centerRepository.findById(centerCode);
        FresherCenter fresherCenter = new FresherCenter();
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
        }else if(center.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL_ERROR);
        }else if (fresherCenterRepository.getFC(fresherId,centerCode).isPresent()){
            throw new NotFoundException(ErrorMessages.FRESHER_CENTER_EXISTS_ERROR);
        }
        fresherRepository.findById(fresherId).ifPresent(fresherCenter::setFresher);
        centerRepository.findById(centerCode).ifPresent(fresherCenter::setCenter);
        return fresherCenterRepository.save(fresherCenter);
    }
    @Override
    public Transcript addScore(Score score, String fresherId, String subjectId) {
        Optional<Fresher> fresher = fresherRepository.findById(fresherId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
        }else if(subject.isEmpty()) {
            throw new NotFoundException(ErrorMessages.SUBJECT_NULL_ERROR);
        }else if (scoreRepository.getScore(fresherId,subjectId).isPresent()){
            throw new NotFoundException(ErrorMessages.SCORE_EXISTS_ERROR);
        }
        fresherRepository.findById(fresherId).ifPresent(score::setFresher);
        subjectRepository.findById(subjectId).ifPresent(score::setSubject);
        scoreRepository.save(score);
        return new Transcript(score);
    }

}
