package io.pragra.learning.jparelationships.repo;

import io.pragra.learning.jparelationships.entities.StudentPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPermitRepo extends JpaRepository<StudentPermit,Integer> {
}
