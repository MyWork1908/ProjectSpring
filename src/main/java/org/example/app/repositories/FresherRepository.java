package org.example.app.repositories;

import org.example.app.models.response.Transcript;
import org.example.app.models.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, String> {
    @Query("SELECT new org.example.app.models.response.Transcript" +
            "(f.fresherName, sb.lp, sc.score01, sc.score02, sc.score03, (sc.score01+sc.score02+sc.score03)/3) " +
            "From Fresher f INNER JOIN Score sc ON sc.fresher.fresherId = f.fresherId INNER JOIN " +
            "Subject sb ON sb.subjectId = sc.subject.subjectId")
    public List<Transcript> getTranscript();
    @Query("SELECT new org.example.app.models.entity.Fresher" +
            "(f.fresherId ,f.fresherName, f.fresherAddress, f.fresherPhone, f.fresherEmail) " +
            "From Fresher f INNER JOIN Score sc ON sc.fresher.fresherId = f.fresherId INNER JOIN " +
            "Subject sb ON sb.subjectId = sc.subject.subjectId " +
            "WHERE sb.lp = :lp")
    public List<Fresher> findByFresherWithLP(String lp);
    public List<Fresher> findByFresherName(String fresherId);
    public Optional<Fresher> findByFresherEmail(String fresherEmail);
}
