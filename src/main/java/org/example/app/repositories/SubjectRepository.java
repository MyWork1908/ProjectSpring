package org.example.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.app.models.entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
