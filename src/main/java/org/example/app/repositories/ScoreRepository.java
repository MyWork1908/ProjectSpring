package org.example.app.repositories;

import org.example.app.models.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT new org.example.app.models.entity.Score" +
            "(sc.scoreId, sc.score01, sc.score02, sc.score03, sc.fresher, sc.subject) " +
            "FROM Score sc WHERE sc.fresher.fresherId = :fresherId AND sc.subject.subjectId = :subjectId")
    public Optional<Score> getScore(String fresherId, String subjectId);
}