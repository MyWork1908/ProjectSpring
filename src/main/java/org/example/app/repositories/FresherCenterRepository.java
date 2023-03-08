package org.example.app.repositories;

import org.example.app.models.entity.FresherCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FresherCenterRepository extends JpaRepository<FresherCenter, Long> {
    @Query("SELECT new org.example.app.models.entity.FresherCenter" +
            "(fc.fresherCenterId, fc.fresher, fc.center) FROM FresherCenter fc " +
            "WHERE fc.fresher.fresherId = :fresherId AND fc.center.centerCode = :centerCode")
    public Optional<FresherCenter> getFC(String fresherId, String centerCode);
}
