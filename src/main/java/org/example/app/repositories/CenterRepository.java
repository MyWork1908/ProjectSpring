package org.example.app.repositories;

import org.example.app.models.entity.Center;
import org.example.app.models.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center, String> {
    @Query("SELECT new org.example.app.models.entity.Fresher" +
            "(f.fresherId ,f.fresherName, f.fresherAddress, f.fresherPhone, f.fresherEmail) " +
            "From Fresher f INNER JOIN FresherCenter fc ON fc.fresher.fresherId = f.fresherId INNER JOIN " +
            "Center ce ON ce.centerCode = fc.center.centerCode " +
            "WHERE ce.centerCode = :centerCode")
    public List<Fresher> getFresherOfCenter(String centerCode);
    public List<Center> findByCenterCode(String centerCode);
}
