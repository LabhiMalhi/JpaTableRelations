package io.pragra.learning.jparelationships.repo;

import io.pragra.learning.jparelationships.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
